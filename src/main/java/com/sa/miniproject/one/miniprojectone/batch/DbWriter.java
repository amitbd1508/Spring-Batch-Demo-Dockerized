package com.sa.miniproject.one.miniprojectone.batch;


import com.sa.miniproject.one.miniprojectone.entity.Student;
import com.sa.miniproject.one.miniprojectone.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DbWriter implements ItemWriter<Student> {

  private final StudentService studentService;

  @Override
  public void write(List<? extends Student> list) {
    studentService.saveAll((List<Student>) list);
  }
}
