package com.grabathon.booster.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "badge")
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
