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
//    default
    void saveUserSubscription(Long user_id, Long subscription_id);

//    @NativeQuery(value = "SELECT * " +
//            "FROM users as u " +
//            "LEFT OUTER JOIN users_subscriptions as u_s ON (u.id=u_s.user_id) " +
//            "LEFT OUTER JOIN subscriptions as s ON (u_s.subscription_id=s.id) " +
//            "WHERE u.id=?1")
//    Optional<User> getUserWithSubscriptionsByUserId(Long id);

//    {
//        User user = getReferenceById(id);
//        user.getSubscriptions().add(subscription);
//        return user;
//    }

//    Optional<User> findByUsername(String username);
    /*
    @Query(value = "SELECT id, name, value,measured_date_time FROM clinicaldata c WHERE c.patient_id=?1 AND c.name=?2 " , nativeQuery=true)

     */
}