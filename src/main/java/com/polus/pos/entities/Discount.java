package com.polus.pos.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Discount {
  @Id
  private UUID id;
  private String description;
  private double percentage;
  private Date creationDate;

  public Discount(String description, double percentage) {
    this.description = description;
    this.percentage = percentage;
  }
}
