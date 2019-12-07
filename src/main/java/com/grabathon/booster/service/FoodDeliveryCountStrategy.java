package com.grabathon.booster.service;

import com.grabathon.booster.model.User;
import com.grabathon.booster.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FoodDeliveryCountStrategy implements BadgeTypeStrategy {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public float getProgressForUser(User user) {
        return transactionRepository.findTransactionsByUserCount(user);
    }
}
