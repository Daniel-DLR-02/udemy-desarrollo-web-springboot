package com.udemy.springninja.controller;

import com.udemy.springninja.components.RequestTimeInterceptor;
import com.udemy.springninja.service.Ejercicio1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/ejercicio")
public class Ejercicio1Controller {

    private static final String HELLO_SCREEN = "hello";

    @Autowired
    @Qualifier("ejercicio1Service")
    private Ejercicio1Service ejercicio1Service;

    @Autowired
    @Qualifier("requestTimeInterceptor")
    private RequestTimeInterceptor requestTimeInterceptor;

    @GetMapping("/")
    public RedirectView redirect(){
        return new RedirectView("/ejercicio/1");
    }

    @GetMapping("/1")
    public ModelAndView sayHello(){
        ModelAndView mav = new ModelAndView(HELLO_SCREEN);
        mav.addObject("saludo","hola");
        ejercicio1Service.showLog();
        return mav;
    }
}
