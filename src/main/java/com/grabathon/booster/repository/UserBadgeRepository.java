package com.grabathon.booster.repository;

import com.grabathon.booster.model.Badge;
import com.grabathon.booster.model.User;
import com.grabathon.booster.model.UserBadge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBadgeRepository extends JpaRepository<UserBadge, Integer> {
    List<UserBadge> findByUser(User user);
}
