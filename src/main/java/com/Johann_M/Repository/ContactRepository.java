package com.Johann_M.Repository;

import com.Johann_M.Entity.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact,Integer> {
}
