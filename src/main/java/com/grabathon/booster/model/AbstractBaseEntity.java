package com.grabathon.booster.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class AbstractBaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  /**
   * The created at.
   */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", nullable = false, length = 19)
  @CreationTimestamp
  protected Date createdAt;

  /**
   * The modified at.
   */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "modified_at", length = 19)
  @UpdateTimestamp
  protected Date modifiedAt;

  /**
   * The deleted at.
   */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "deleted_at", length = 19)
  protected Date deletedAt;
}
