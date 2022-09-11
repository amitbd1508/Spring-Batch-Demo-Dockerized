package com.sa.miniproject.one.miniprojectone.mapper;

import com.sa.miniproject.one.miniprojectone.dto.StudentDto;
import com.sa.miniproject.one.miniprojectone.entity.Student;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

public class StudentFieldSetMapper implements FieldSetMapper<StudentDto> {

  @Override
  public StudentDto mapFieldSet(FieldSet fieldSet) {
    return new StudentDto(fieldSet.readLong("id"),
      fieldSet.readString("firstname"),
      fieldSet.readString("lastname"),
      fieldSet.readDouble("gpa"),
      fieldSet.readInt("age"));
  }
}
