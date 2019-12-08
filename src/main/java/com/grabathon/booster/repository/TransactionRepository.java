package com.grabathon.booster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grabathon.booster.dto.TransactionRequestDTO;
import com.grabathon.booster.model.Transaction;
import com.grabathon.booster.model.User;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
  Integer countByUser(User user);

  void save(TransactionRequestDTO transactionRequestDTO);
}
