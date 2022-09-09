package com.sa.miniproject.one.miniprojectone.service.impl;

import com.sa.miniproject.one.miniprojectone.entity.Person;
import com.sa.miniproject.one.miniprojectone.repository.PersonRepository;
import com.sa.miniproject.one.miniprojectone.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
  private final PersonRepository personRepository;

  @Override
  public void deleteAll() {
    personRepository.deleteAll();
  }

  @Override
  public void saveAll(List<Person> personList) {
    personRepository.saveAll(personList);

  }
}
