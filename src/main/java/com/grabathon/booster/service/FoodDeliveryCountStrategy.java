package com.grabathon.booster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grabathon.booster.model.User;
import com.grabathon.booster.repository.TransactionRepository;

@Component
public class FoodDeliveryCountStrategy implements BadgeTypeStrategy {

  @Autowired
  private TransactionRepository transactionRepository;

  @Override
  public float getProgressForUser(User user) {
    return transactionRepository.countByUser(user);
  }
}
