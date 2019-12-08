package com.grabathon.booster.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TransactionRequestDTO {
  private Integer id;

  private Date created_at;

  private Date modified_at;

  private Integer user_id;

  private Integer merchant_id;

  private Float amount;
}
