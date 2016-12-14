package com.github.kapmahc.auth.repositories;

import com.github.kapmahc.auth.models.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by flamen on 16-12-14.
 */
@Repository("auth.contactRepository")
public interface ContactRepository extends CrudRepository<Contact, Long> {
}
