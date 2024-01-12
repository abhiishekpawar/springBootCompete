package com.example.UnitTestsDemo.Repository;

import com.example.UnitTestsDemo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
