package com.sa.miniproject.one.miniprojectone.batch;


import com.sa.miniproject.one.miniprojectone.model.Person;
import com.sa.miniproject.one.miniprojectone.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DbWriter implements ItemWriter<Person> {

    private final PersonRepository personRepository;

    @Override
    public void write(List<? extends Person> list) throws Exception {

      System.out.println(list);
        System.out.println("In Item Writer");
        personRepository.saveAll(list);
    }
}
