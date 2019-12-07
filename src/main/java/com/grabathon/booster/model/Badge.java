package com.grabathon.booster.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "badge_types")
public class Badge extends AbstractBaseEntity implements Serializable {

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "cutoff", nullable = false)
    private float cutoff;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "badge_type_id", nullable = false)
    private BadgeType badgeType;

    @ManyToMany(mappedBy = "badges")
    private Set<User> users;
}
