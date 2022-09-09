package com.sa.miniproject.one.miniprojectone.service;

import com.sa.miniproject.one.miniprojectone.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {
  void deleteAll();
  void saveAll(List<Person> personList);
}
