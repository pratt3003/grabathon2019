package com.grabathon.booster.service;

import com.grabathon.booster.model.User;

public interface BadgeTypeStrategy {
    float getProgressForUser(User user);
}
