package com.sa.miniproject.one.miniprojectone.repository;

import com.sa.miniproject.one.miniprojectone.entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    User findByEmail(String email);
}
