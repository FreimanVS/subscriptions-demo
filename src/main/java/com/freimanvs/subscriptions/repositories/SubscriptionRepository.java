package com.freimanvs.subscriptions.repositories;

import com.freimanvs.subscriptions.dto.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

//    @NativeQuery(value = "SELECT s.id, s.name, COUNT(user_id) " +
//            "FROM users_subscriptions as u_s " +
//            "INNER JOIN subscriptions as s ON (u_s.subscription_id = s.id) " +
//            "GROUP BY subscription_id " +
//            "ORDER BY COUNT(user_id) " +
//            "DESC LIMIT 3;")
    @NativeQuery(value = "SELECT * FROM subscriptions as s2 " +
            "WHERE s2.id in (" +
            "SELECT u_s.subscription_id " +
            "FROM users_subscriptions as u_s " +
            "GROUP BY u_s.subscription_id " +
            "ORDER BY COUNT(u_s.user_id) DESC " +
            "LIMIT 3" +
            ");")

    List <Subscription> getTopThree();
}