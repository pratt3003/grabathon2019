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
@Table(name = "coupon")
public class Coupon extends AbstractBaseEntity implements Serializable {

  @Column(name = "code")
  private String code;

  @Column(name = "discount")
  private float discount;
}
