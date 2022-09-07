package com.sa.miniproject.one.miniprojectone.batch;

import com.sa.miniproject.one.miniprojectone.model.Person;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;

@Component
public class DbProcessor implements ItemProcessor<Person, Person> {

  private static final HashMap<String, String> REVIEW_MAPPING = new HashMap<>();

  @Override
  public Person process(Person person) throws Exception {

    person.setAge(person.getAge() + 100);


    return person;
  }
}
