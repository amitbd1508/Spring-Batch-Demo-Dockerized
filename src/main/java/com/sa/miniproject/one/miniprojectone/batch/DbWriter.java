package com.sa.miniproject.one.miniprojectone.batch;


import com.sa.miniproject.one.miniprojectone.entity.Person;
import com.sa.miniproject.one.miniprojectone.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DbWriter implements ItemWriter<Person> {

  private final PersonService personService;

  @Override
  public void write(List<? extends Person> list) {
    personService.saveAll((List<Person>) list);
  }
}
