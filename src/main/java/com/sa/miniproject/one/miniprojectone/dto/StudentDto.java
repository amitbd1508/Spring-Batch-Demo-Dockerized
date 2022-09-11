package com.sa.miniproject.one.miniprojectone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
  private long id;
  private String firstName;
  private String lastName;
  private double gpa;
  private int age;
}
