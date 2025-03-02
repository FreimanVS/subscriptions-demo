package com.freimanvs.subscriptions.services.impls;

import com.freimanvs.subscriptions.dto.Subscription;
import com.freimanvs.subscriptions.exceptions.SubscriptionsException;
import com.freimanvs.subscriptions.repositories.SubscriptionRepository;
import com.freimanvs.subscriptions.services.CommonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SubscriptionService implements CommonService<Subscription> {

    private final SubscriptionRepository subscriptionRepository;

    public Subscription save(Subscription subscription) {
        subscription.setId(null);
        subscription.setUsers(null);
        return subscriptionRepository.save(subscription);
    }

    public Subscription getById(Long id) {
        return subscriptionRepository.findById(id)
                .orElseThrow(() -> new SubscriptionsException("Not founded subscription by id " + id));
    }

    public Subscription update(Long id, Subscription subscription) {
        Subscription olderSubscription = getById(id);
        olderSubscription.setName(subscription.getName());
        return subscriptionRepository.save(olderSubscription);
    }

    public void delete(Long id) {
        subscriptionRepository.deleteById(id);
    }

    public List<Subscription> getTopThree() {
        return subscriptionRepository.getTopThree();
    }
}
