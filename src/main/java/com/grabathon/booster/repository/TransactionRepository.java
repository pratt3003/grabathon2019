package com.grabathon.booster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grabathon.booster.model.Transaction;
import com.grabathon.booster.model.User;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
  Integer countTransactionsByUser(User user);
}
