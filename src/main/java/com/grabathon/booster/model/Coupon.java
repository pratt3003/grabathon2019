package com.grabathon.booster.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "coupons")
public class Coupon extends AbstractBaseEntity implements Serializable {

    @Column(name = "code")
    private String code;

    @Column(name = "discount")
    private float discount;
}
