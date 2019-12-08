package com.grabathon.booster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grabathon.booster.model.Badge;
import com.grabathon.booster.model.User;
import com.grabathon.booster.model.UserBadge;

@Repository
public interface UserBadgeRepository extends JpaRepository<UserBadge, Integer> {
  List<UserBadge> findByUser(User user);

  Integer countByUserAndBadge(User user, Badge badge);
}
