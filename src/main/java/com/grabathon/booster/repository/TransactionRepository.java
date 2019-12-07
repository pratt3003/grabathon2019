package com.grabathon.booster.repository;

import com.grabathon.booster.model.Transaction;
import com.grabathon.booster.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Integer findTransactionsByUserCount(User user);
}
