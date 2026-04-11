package com.contact.repository;

import com.contact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByLastNameContainingIgnoreCase(String lastName);

    List<Contact> findByCompanyContainingIgnoreCase(String company);

    List<Contact> findByFavoriteTrue();
}

