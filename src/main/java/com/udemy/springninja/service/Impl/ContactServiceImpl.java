package com.udemy.springninja.service.Impl;

import com.udemy.springninja.components.ContactConverter;
import com.udemy.springninja.entity.Contact;
import com.udemy.springninja.model.ContactModel;
import com.udemy.springninja.repository.ContactRepository;
import com.udemy.springninja.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;

    @Autowired
    @Qualifier("contactConverter")
    private ContactConverter contactConverter;

    @Override
    public ContactModel addContact(ContactModel contactModel) {
        Contact nuevoContacto = contactRepository.save(contactConverter.contactModelToContact(contactModel));
        return contactConverter.contactToContactModel(nuevoContacto);
    }

    @Override
    public List<ContactModel> listAllContacts() {
        return contactRepository.findAll().stream().map(contactConverter::contactToContactModel).collect(Collectors.toList());
    }

    @Override
    public Contact findContactById(Long id) {
        Optional<Contact> contactoBuscado = contactRepository.findById(id);
        if(contactoBuscado.isPresent())
            return contactoBuscado.get();
        else
            throw new EntityNotFoundException("Contacto no encontrado");

    }

    @Override
    public ContactModel findContactByIdModel(Long id) {
        return contactConverter.contactToContactModel(findContactById(id));
    }

    @Override
    public void removeContact(Long id) {
        contactRepository.deleteById(id);
    }
}
