package com.udemy.springninja.service;

import com.udemy.springninja.entity.Contact;
import com.udemy.springninja.model.ContactModel;

import java.util.List;

public interface ContactService {

    public abstract ContactModel addContact(ContactModel contactModel);

    public abstract List<ContactModel> listAllContacts();

    public abstract ContactModel findContactByIdModel(Long id);

    public abstract Contact findContactById(Long id);

    public abstract void removeContact(Long id);
}
