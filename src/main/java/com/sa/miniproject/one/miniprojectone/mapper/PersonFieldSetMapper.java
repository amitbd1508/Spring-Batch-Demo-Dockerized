package com.sa.miniproject.one.miniprojectone.mapper;

import com.sa.miniproject.one.miniprojectone.model.Person;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

public class PersonFieldSetMapper implements FieldSetMapper<Person> {

  @Override
  public Person mapFieldSet(FieldSet fieldSet) {
    return new Person(fieldSet.readLong("id"),
      fieldSet.readString("firstname"),
      fieldSet.readString("lastname"),
      fieldSet.readDouble("gpa"),
      fieldSet.readInt("age"));
  }
}
