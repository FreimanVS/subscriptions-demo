package com.freimanvs.subscriptions.repositories;

import com.freimanvs.subscriptions.dto.Subscription;
import com.freimanvs.subscriptions.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @NativeQuery(value = "SELECT s.id, s.name from users_subscriptions as u_s " +
            "INNER JOIN subscriptions as s ON (u_s.subscription_id=s.id) " +
            "WHERE u_s.user_id=?1")
    List<Subscription> getUserSubscriptions(Long id);

    @NativeQuery(value = "INSERT INTO users_subscriptions(user_id, subscription_id) VALUES(?1, ?2);")
    void saveUserSubscription(Long user_id, Long subscription_id);
}