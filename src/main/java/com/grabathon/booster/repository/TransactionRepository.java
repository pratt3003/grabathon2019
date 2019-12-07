package com.grabathon.booster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grabathon.booster.model.Transaction;
import com.grabathon.booster.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
//  @Query("select count(t) from Transaction t where t.user = ?1")
//  Integer countByUser(User user);
  List<Transaction> findByUser(User user);
}
