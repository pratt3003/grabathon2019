package com.grabathon.booster.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.awt.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "merchants")
public class Merchant extends AbstractBaseEntity implements Serializable {

    @Column(name = "name", nullable =  false, length = 50)
    private String name;

    @JsonIgnore
    @Column(name = "location")
    private Point location;
}
