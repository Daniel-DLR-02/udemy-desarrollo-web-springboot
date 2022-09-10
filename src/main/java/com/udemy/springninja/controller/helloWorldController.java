package com.udemy.springninja.controller;


import com.udemy.springninja.components.ExampleComponent;
import com.udemy.springninja.model.Person;
import com.udemy.springninja.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/holamundo")
public class helloWorldController {

    private static final String EXAMPLE_VIEW = "example2";

    @Autowired
    @Qualifier("exampleService")
    private ExampleService exampleService;

    @Autowired
    @Qualifier("exampleComponent")
    private ExampleComponent exampleComponent;

    @GetMapping("/say")
    public String helloWorld(Model model){
        model.addAttribute("people", exampleService.getListPeople());
        return "helloworld";
    }

    @GetMapping("exampleString")
    public String exampleString(Model model){
        exampleComponent.sayhello();
        model.addAttribute("people", exampleService.getListPeople());
        return EXAMPLE_VIEW;
    }

}
