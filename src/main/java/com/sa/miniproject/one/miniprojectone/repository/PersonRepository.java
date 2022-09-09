package com.sa.miniproject.one.miniprojectone.repository;

import com.sa.miniproject.one.miniprojectone.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Person> {
}
