package com.example.springbootrestapitest.repository;

import com.example.springbootrestapitest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
