package com.grabathon.booster.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<E, I extends Serializable> extends JpaRepository<E, I> {
}
