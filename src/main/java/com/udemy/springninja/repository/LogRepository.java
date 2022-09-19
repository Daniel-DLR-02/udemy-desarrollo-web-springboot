package com.udemy.springninja.repository;

import com.udemy.springninja.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("logRepository")
public interface LogRepository extends JpaRepository<Log, Long> {
}
