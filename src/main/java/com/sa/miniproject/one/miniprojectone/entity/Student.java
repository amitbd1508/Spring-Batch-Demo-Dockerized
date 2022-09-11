package com.sa.miniproject.one.miniprojectone.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String firstName;
  private String lastName;
  private double gpa;
  private Date dateOfBirth;
}
