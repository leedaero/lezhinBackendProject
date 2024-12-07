package com.example.lezhinbackendtestproject.repository.user;

import com.example.lezhinbackendtestproject.entity.order.Order;
import com.example.lezhinbackendtestproject.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByUserId(String userId);
    Optional<User> findByUserIdAndStatus(String userId, String status);
}
