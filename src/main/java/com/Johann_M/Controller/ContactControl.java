package com.Johann_M.Controller;

import com.Johann_M.Entity.Contact;
import com.Johann_M.Exception.ContactNotFoundException;
import com.Johann_M.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ContactControl {
    @Autowired
    private ContactService service;

    @GetMapping("/contacts")
    public String showContactList(Model model){
        List<Contact> contactList = service.listAll();
        model.addAttribute("contactList", contactList);
        return "contacts";
    }

    @RequestMapping(value = "/contacts/new", method = RequestMethod.GET)//@GetMapping(value = "/contacts/new")
    public ModelAndView showNewForm(ModelMap model) {
        model.addAttribute("pagetitle", "Neuer Kontakt");
        return new ModelAndView("contactForm", "contact", new Contact());
    }

    @RequestMapping(value = "/contacts/new/save", method = RequestMethod.POST)
    public String submit(@ModelAttribute("contact")Contact con, BindingResult result) {
        if (result.hasErrors()) {
            return "error";
        }
        service.save(con);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "/contacts/edit/{id}", method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable("id") Integer id, ModelMap model) {
        try {
            Contact con = service.getContactById(id);
            model.addAttribute("pagetitle", "Kontakt ändern");
            return new ModelAndView("contactForm", "contact", con);
        } catch (ContactNotFoundException e) {
            return new ModelAndView("contacts");
        }
    }

    @RequestMapping(value = "/contacts/delete/{id}", method = RequestMethod.GET)
    public String deleteById(@PathVariable("id") Integer id, RedirectAttributes ra) {
        service.delete(id);
        ra.addFlashAttribute("Kontakt mit ID " + id + "erfolgreich gelöscht.");
        return "redirect:/contacts";
    }

}
