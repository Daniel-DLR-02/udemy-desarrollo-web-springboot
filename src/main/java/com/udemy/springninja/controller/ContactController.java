package com.udemy.springninja.controller;

import com.udemy.springninja.constants.ViewConstant;
import com.udemy.springninja.entity.Contact;
import com.udemy.springninja.model.ContactModel;
import com.udemy.springninja.service.ContactService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    @Qualifier("contactService")
    private ContactService contactService;

    private static final Log LOG = LogFactory.getLog(ContactController.class);

    @GetMapping("/cancel")
    public String cancel(){
        return "redirect:/contacts/showcontacts";
    }

    @GetMapping("/contactform")
    private ModelAndView redirectContactForm(Model model,@RequestParam(name = "id",required = false) Long id){
        ModelAndView mov = new ModelAndView(ViewConstant.CONTACT_FORM);
        ContactModel contactBuscado = new ContactModel();
        if(id != 0){
            contactBuscado = contactService.findContactByIdModel(id);
        }
        model.addAttribute("contactModel", contactBuscado);
        return mov;
    }

    @PostMapping("/addcontact")
    public String addContact(@ModelAttribute(name = "contactModel") ContactModel contactModel,
                             Model model){
        LOG.info("METHOD: addContact() -- PARAMS "+contactModel.toString());

        if(null != contactService.addContact(contactModel)){
            model.addAttribute("result",1);
        }else{
            model.addAttribute("result",0);
        }

        return "redirect:/contacts/showcontacts";
    }

    @GetMapping("/showcontacts")
    public ModelAndView showContacts(){
        ModelAndView mov = new ModelAndView(ViewConstant.CONTACTS);
        mov.addObject("contacts",contactService.listAllContacts());
        return mov;
    }

    @GetMapping("/removecontact")
    public ModelAndView removeContact(@RequestParam(name = "id",required = true) Long id){
        contactService.removeContact(id);
        return showContacts();
    }

}
