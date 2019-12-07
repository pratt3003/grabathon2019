package com.grabathon.booster.factory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grabathon.booster.constants.BadgeTypes;
import com.grabathon.booster.service.BadgeTypeStrategy;
import com.grabathon.booster.service.FoodDeliveryCountStrategy;

import javax.annotation.PostConstruct;

@Component
public class BadgeTypeFactory {

  private Map<String, BadgeTypeStrategy> badgeTypeStrategyMap;

  @Autowired
  private FoodDeliveryCountStrategy foodDeliveryCountStrategy;

  @PostConstruct
  private void init() {
    badgeTypeStrategyMap = new HashMap<>();
    badgeTypeStrategyMap
        .put(BadgeTypes.FOOD_DELIVERY_COUNT_BADGE.name().toLowerCase(), foodDeliveryCountStrategy);
  }

  public BadgeTypeStrategy getBadgeTypeStrategy(String badgeName) {
    BadgeTypeStrategy badgeTypeStrategy = badgeTypeStrategyMap.get(badgeName);
    if (badgeTypeStrategy == null) {
      throw new RuntimeException("No strategy found for badge " + badgeName + "  keys" + badgeTypeStrategyMap.keySet());
    }

    return badgeTypeStrategy;
  }
}
