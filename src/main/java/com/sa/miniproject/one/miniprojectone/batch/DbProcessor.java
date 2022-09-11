package com.sa.miniproject.one.miniprojectone.batch;

import com.sa.miniproject.one.miniprojectone.dto.StudentDto;
import com.sa.miniproject.one.miniprojectone.entity.Student;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class DbProcessor implements ItemProcessor<StudentDto, Student> {
  @Override
  public Student process(StudentDto studentDto) {

    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.YEAR, - studentDto.getAge());

    return new Student(studentDto.getId(), studentDto.getFirstName(), studentDto.getFirstName(), studentDto.getGpa(), calendar.getTime());
  }
}
