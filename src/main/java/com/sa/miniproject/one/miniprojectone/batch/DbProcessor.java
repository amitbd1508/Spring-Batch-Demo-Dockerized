package com.sa.miniproject.one.miniprojectone.batch;

import com.sa.miniproject.one.miniprojectone.entity.Person;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class DbProcessor implements ItemProcessor<Person, Person> {
  @Override
  public Person process(Person person) {

    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.YEAR, -person.getAge());
    person.setDateOfBirth(calendar.getTime());

    return person;
  }
}
