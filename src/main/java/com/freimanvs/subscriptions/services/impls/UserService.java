package com.freimanvs.subscriptions.services.impls;

import com.freimanvs.subscriptions.dto.Subscription;
import com.freimanvs.subscriptions.dto.User;
import com.freimanvs.subscriptions.exceptions.SubscriptionsException;
import com.freimanvs.subscriptions.repositories.UserRepository;
import com.freimanvs.subscriptions.services.CommonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements CommonService<User> {

    private final UserRepository userRepository;
    private final SubscriptionService subscriptionService;

    public User save(User user) {
        user.setId(null);
        user.setSubscriptions(null);
        return userRepository.save(user);
    }

    @Transactional
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new SubscriptionsException("Not founded user by id " + id));
    }

    public User update(Long id, User user) {
        User olderUser = getById(id);
        olderUser.setSurname(user.getSurname());
        olderUser.setUsername(user.getUsername());
        olderUser.setName(user.getName());
        olderUser.setEmail(user.getEmail());
        olderUser.setPassword(user.getPassword());

        return userRepository.save(olderUser);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Subscription> getUserSubscriptions(Long id) {
        User user = getById(id);
        return user.getSubscriptions();
    }

    @Transactional
    public User saveUserSubscription(Long userId, Long subscriptionId) {
        User user = getById(userId);
        Subscription s = subscriptionService.getById(subscriptionId);
        user.getSubscriptions().add(s);
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUserSubscription(Long userId, Long subscriptionId) {
        User user = getById(userId);
        Subscription subscription = subscriptionService.getById(subscriptionId);
        user.getSubscriptions().remove(subscription);
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
