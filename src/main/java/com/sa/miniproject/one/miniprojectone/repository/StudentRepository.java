package com.sa.miniproject.one.miniprojectone.repository;

import com.sa.miniproject.one.miniprojectone.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Student> {
}
