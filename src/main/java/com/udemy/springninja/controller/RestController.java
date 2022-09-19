package com.udemy.springninja.controller;

import com.udemy.springninja.model.ContactModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("rest")
public class RestController {

    @GetMapping("/checkrest")
    public ResponseEntity<ContactModel> checkRest() {
        ContactModel cm = new ContactModel(4L, "Antonio", "perez", "54234125", "Sevilla");
        return new ResponseEntity<ContactModel>(cm, HttpStatus.OK);
    }
}
