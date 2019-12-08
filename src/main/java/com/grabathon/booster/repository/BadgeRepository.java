package com.grabathon.booster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grabathon.booster.model.Badge;
import com.grabathon.booster.model.BadgeType;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Integer> {
  Badge findFirstByBadgeTypeAndMilestoneGreaterThanOrderByMilestoneAsc(BadgeType badgeType,
      Float limit);

  List<Badge> findAllByBadgeType(BadgeType badgeType);
}
