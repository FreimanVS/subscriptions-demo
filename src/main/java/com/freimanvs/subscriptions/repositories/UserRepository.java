package com.freimanvs.subscriptions.repositories;

import com.freimanvs.subscriptions.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional(readOnly = true)
    @Query("FROM users u LEFT JOIN FETCH u.subscriptions")
    @Override
    List<User> findAll();

    @Transactional(readOnly = true)
    @Query("FROM users u LEFT JOIN FETCH u.subscriptions " +
            "WHERE u.id = :userId")
    @Override
    Optional<User> findById(Long userId);
}