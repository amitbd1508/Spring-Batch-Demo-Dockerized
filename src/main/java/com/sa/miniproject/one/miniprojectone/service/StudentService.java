package com.sa.miniproject.one.miniprojectone.service;

import com.sa.miniproject.one.miniprojectone.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
  void deleteAll();
  void saveAll(List<Student> studentList);
}
