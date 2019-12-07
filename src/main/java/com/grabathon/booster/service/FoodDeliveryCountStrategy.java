package com.grabathon.booster.service;

import com.grabathon.booster.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grabathon.booster.model.User;
import com.grabathon.booster.repository.TransactionRepository;

import java.util.List;

@Component
public class FoodDeliveryCountStrategy implements BadgeTypeStrategy {

  @Autowired
  private TransactionRepository transactionRepository;

  @Override
  public float getProgressForUser(User user) {
    List<Transaction> transactionList = transactionRepository.findAll();
    return transactionList.size();
  }
}
