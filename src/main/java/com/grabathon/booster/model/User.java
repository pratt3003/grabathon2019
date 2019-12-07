package com.grabathon.booster.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "user")
public class User extends AbstractBaseEntity implements Serializable {

  @Column(name = "name", nullable = false, length = 50)
  private String name;
}
