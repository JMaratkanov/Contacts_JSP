package com.Johann_M.Service;

import com.Johann_M.Entity.Adress;
import com.Johann_M.Exception.AdressNotFoundException;
import com.Johann_M.Repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdressService {

    @Autowired
    private AdressRepository repo;

    public List<Adress> listAll(Integer id){
        return repo.findByContactID(id);
    }

    public void save(Adress adress) {
        repo.save(adress);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

    public Adress getAdressById(Integer id) throws AdressNotFoundException {
        Optional<Adress> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new AdressNotFoundException("Datenbankfehler: Keine Adresse mit dieser ID gefunden!");
    }
}
