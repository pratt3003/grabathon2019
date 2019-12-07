package com.grabathon.booster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grabathon.booster.model.Message;

@Repository
public interface HelloWorldRepository extends JpaRepository<Message, Integer> {

  // custom query to search to blog post by title or content
  List<Message> findAll();

}
