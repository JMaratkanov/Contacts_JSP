package com.Johann_M.Service;
import com.Johann_M.Entity.Contact;
import com.Johann_M.Exception.ContactNotFoundException;
import com.Johann_M.Repository.ContactRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository repo;

    public ContactService(ContactRepository repo) {
        this.repo = repo;
    }

    public List<Contact> listAll(){
        return (List<Contact>) repo.findAll();
    }

    public void save(Contact contact) {
        repo.save(contact);
    }

    public void delete(Integer id){
        repo.deleteById(id);            //löscht zugehörige Adressen automatisch wegen FK(contact_fk) delete on cascade
    }

    public Contact getContactById(Integer id) throws ContactNotFoundException {
        Optional<Contact> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new ContactNotFoundException("Datenbankfehler: Kein Kontakt mit dieser ID gefunden!");
    }
}
