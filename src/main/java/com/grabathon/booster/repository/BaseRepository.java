package com.grabathon.booster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface BaseRepository<E, I extends Serializable> extends JpaRepository<E, I> {
}
