package com.polus.pos.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Discount {
  @Id
  private UUID id;
  @Column(name = "description")
  private String description;
  @Column(name = "percentage")
  private double percentage;
  @Column(name = "creationDate")
  private Date creationDate;

  public Discount(UUID id, String description, double percentage, Date creationDate) {
    this.id = id;
    this.description = description;
    this.percentage = percentage;
    this.creationDate = creationDate;
  }
}
