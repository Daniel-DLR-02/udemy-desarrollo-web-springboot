package com.udemy.springninja.repository;

import com.udemy.springninja.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact, Long> {

    public abstract Optional<Contact> findById(Long id);
}
