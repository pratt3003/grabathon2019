package com.grabathon.booster.service;

import com.grabathon.booster.model.User;

public class FoodDeliveryCountStrategy implements BadgeTypeStrategy {
    @Override
    public float getProgressForUser(User user) {
        return 0;
    }
}
