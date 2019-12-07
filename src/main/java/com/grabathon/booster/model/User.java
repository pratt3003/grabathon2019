package com.grabathon.booster.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "users")
public class User extends AbstractBaseEntity implements Serializable {

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_badges", joinColumns = {@JoinColumn(referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")})
    private Set<Badge> badges;
}
