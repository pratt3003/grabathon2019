package com.grabathon.booster.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grabathon.booster.model.BadgeType;

@Repository
public interface BadgeTypeRepository extends JpaRepository<BadgeType, Integer> {
  Page<BadgeType> findAll(Pageable pageable);

  BadgeType findByName(String badgeTypeName);
}
