package com.grabathon.booster.repository;

import com.grabathon.booster.model.Badge;
import com.grabathon.booster.model.BadgeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BadgeRepository extends JpaRepository<Badge, Integer> {
    Badge find1ByBadgetypeAndCutoffGreaterThanOrderByCutOffAsc(BadgeType badgeType, Float limit);
}
