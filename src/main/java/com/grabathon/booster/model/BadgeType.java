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
@Table(name = "badge_types")
public class BadgeType extends AbstractBaseEntity implements Serializable {

    @Column(name = "name", nullable = false, length = 50)
    private String name;
}
