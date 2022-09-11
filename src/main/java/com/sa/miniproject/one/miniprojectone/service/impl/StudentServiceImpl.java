package com.sa.miniproject.one.miniprojectone.service.impl;

import com.sa.miniproject.one.miniprojectone.entity.Student;
import com.sa.miniproject.one.miniprojectone.repository.StudentRepository;
import com.sa.miniproject.one.miniprojectone.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
  private final StudentRepository studentRepository;

  @Override
  public void deleteAll() {
    studentRepository.deleteAll();
  }

  @Override
  public void saveAll(List<Student> studentList) {
    studentRepository.saveAll(studentList);

  }
}
