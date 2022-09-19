package com.udemy.springninja.repository;

import com.udemy.springninja.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

    public abstract User findByUsername(String username);

}
