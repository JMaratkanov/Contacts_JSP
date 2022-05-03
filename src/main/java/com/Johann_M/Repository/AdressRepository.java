package com.Johann_M.Repository;

import com.Johann_M.Entity.Adress;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdressRepository extends CrudRepository<Adress, Integer> {
    List<Adress> findByContactID(Integer contactID);
}
