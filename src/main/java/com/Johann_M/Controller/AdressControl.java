package com.Johann_M.Controller;

import com.Johann_M.Entity.Adress;
import com.Johann_M.Exception.AdressNotFoundException;
import com.Johann_M.Service.AdressService;
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
public class AdressControl {

    @Autowired
    private AdressService service;

    @GetMapping("/contacts/adress/{conId}")
    public String showAdressList(@PathVariable("conId") Integer conId, Model model){
        List<Adress> adressList = service.listAll(conId);
        model.addAttribute("adressList", adressList);
        model.addAttribute("conId", conId);
        return "adress";
    }

    @RequestMapping(value = "/contacts/adress/{conId}/new", method = RequestMethod.GET)
    public ModelAndView showNewForm(@PathVariable("conId") Integer conId, ModelMap model) {
        model.addAttribute("pagetitle", "Neue Adresse");
        model.addAttribute("conId", conId);
        return new ModelAndView("adressForm", "adress", new Adress());
    }

    @RequestMapping(value = "/contacts/adress/{conId}/new/save", method = RequestMethod.POST)
    public String submit(@PathVariable("conId") Integer conId, @ModelAttribute("adress")Adress adr, BindingResult result) {
        if (result.hasErrors()) {
            return "error";
        }
        service.save(adr);
        return "redirect:/contacts/adress/" + conId;
    }

    @RequestMapping(value = "/contacts/adress/{conId}/delete/{adrId}", method = RequestMethod.GET)
    public String deleteById(@PathVariable("conId") Integer conId, @PathVariable("adrId") Integer adrId, RedirectAttributes ra) {
        service.delete(adrId);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "/contacts/adress/{conId}/edit/{adrId}", method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable("conId") Integer conId, @PathVariable("adrId") Integer adrId, ModelMap model) {
        try {
            Adress adr = service.getAdressById(adrId);
            model.addAttribute("pagetitle", "Adresse ändern");
            return new ModelAndView("adressForm", "adress", adr);
        } catch (AdressNotFoundException e) {
            return new ModelAndView("contacts");
        }
    }


}
