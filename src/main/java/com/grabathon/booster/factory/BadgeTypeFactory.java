package com.grabathon.booster.factory;

import com.grabathon.booster.constants.BadgeTypes;
import com.grabathon.booster.model.BadgeType;
import com.grabathon.booster.service.BadgeTypeStrategy;
import com.grabathon.booster.service.FoodDeliveryCountStrategy;

import javax.annotation.PostConstruct;
import java.util.Map;

public class BadgeTypeFactory {

    private Map<String, BadgeTypeStrategy> badgeTypeStrategyMap;

    @PostConstruct
    private void init() {
        badgeTypeStrategyMap.put(BadgeTypes.FOOD_DELIVERY_COUNT_BADGE.name(), new FoodDeliveryCountStrategy());
    }

    public BadgeTypeStrategy getBadgeTypeStrategy(String badgeName) {
        BadgeTypeStrategy badgeTypeStrategy = badgeTypeStrategyMap.get(badgeName);
        if (badgeTypeStrategy == null) {
            throw new RuntimeException("No strategy found for badge " + badgeName);
        }

        return badgeTypeStrategy;
    }
}
