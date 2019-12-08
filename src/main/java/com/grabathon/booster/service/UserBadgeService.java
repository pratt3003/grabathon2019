package com.grabathon.booster.service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabathon.booster.factory.BadgeTypeFactory;
import com.grabathon.booster.model.BadgeType;
import com.grabathon.booster.model.User;
import com.grabathon.booster.repository.BadgeRepository;
import com.grabathon.booster.repository.BadgeTypeRepository;
import com.grabathon.booster.repository.UserBadgeRepository;

@Service
public class UserBadgeService {

  private static int id = 0;

  @Autowired
  private BadgeTypeFactory badgeTypeFactory;

  @Autowired
  private BadgeRepository badgeRepository;

  @Autowired
  private BadgeTypeRepository badgeTypeRepository;

  @Autowired
  private UserBadgeRepository userBadgeRepository;

  @Autowired
  private EntityManager entityManager;

  public void evaluateUserBadges(User user) {
    for (String badgeTypeName : badgeTypeFactory.badgeTypeStrategyMap.keySet()) {
      float progress = badgeTypeFactory.getBadgeTypeStrategy(badgeTypeName)
          .getProgressForUser(user);
      BadgeType badgeType = badgeTypeRepository.findByName(badgeTypeName);
      badgeRepository.findAllByBadgeType(badgeType).stream()
          .filter(badge -> badge.getMilestone() <= progress)
          .filter(badge -> userBadgeRepository.countByUserAndBadge(user, badge) == 0)
          .forEach(badge -> {
            id++;

            entityManager.createNativeQuery("INSERT INTO user_badge (id, badge_id, user_id, " +
                "created_at) VALUES (?, ?, ?, now())").setParameter(1, id)
                .setParameter(2, badge.getId()).setParameter(3, user.getId()).
                executeUpdate();

          });
    }
  }
}
