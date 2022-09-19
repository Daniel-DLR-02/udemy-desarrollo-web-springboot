package com.udemy.springninja.components;

import com.udemy.springninja.entity.Contact;
import com.udemy.springninja.model.ContactModel;
import org.springframework.stereotype.Component;

@Component("contactConverter")
public class ContactConverter {

    public Contact contactModelToContact(ContactModel contactModel ){
        Contact contactoNuevo = new Contact();
        contactoNuevo.setId(contactModel.getId());
        contactoNuevo.setFirstname(contactModel.getFirstname());
        contactoNuevo.setLastname(contactModel.getLastname());
        contactoNuevo.setTelephone(contactModel.getTelephone());
        contactoNuevo.setCity(contactModel.getCity());
        return contactoNuevo;
    }

    public ContactModel contactToContactModel(Contact contact){
        return new ContactModel(contact.getId(),contact.getFirstname(),contact.getLastname(),contact.getTelephone(),contact.getCity());
    }

}
