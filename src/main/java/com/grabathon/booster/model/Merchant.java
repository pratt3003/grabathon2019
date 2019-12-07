package com.grabathon.booster.model;

import java.awt.Point;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "merchant")
public class Merchant extends AbstractBaseEntity implements Serializable {

  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @JsonIgnore
  @Column(name = "location", columnDefinition = "Point")
  private Point location;
}
