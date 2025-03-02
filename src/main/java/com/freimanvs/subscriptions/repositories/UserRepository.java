package com.freimanvs.subscriptions.repositories;

import com.freimanvs.subscriptions.dto.Subscription;
import com.freimanvs.subscriptions.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional(readOnly = true)
    @NativeQuery(value = "SELECT s.id, s.name from users_subscriptions as u_s " +
            "INNER JOIN subscriptions as s ON (u_s.subscription_id=s.id) " +
            "WHERE u_s.user_id=?1")
    List<Subscription> getUserSubscriptions(Long id);

    @Transactional
    @NativeQuery(value = "INSERT INTO users_subscriptions(user_id, subscription_id) VALUES(?1, ?2);")
    void saveUserSubscription(Long user_id, Long subscription_id);

    @Transactional(readOnly = true)
    @Query("FROM users u LEFT JOIN FETCH u.subscriptions")
    @Override
    List<User> findAll();
}