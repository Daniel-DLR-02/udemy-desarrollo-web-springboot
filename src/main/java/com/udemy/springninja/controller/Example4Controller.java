package com.udemy.springninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example4")
public class Example4Controller {

    private static final String NOT_FOUND = "404";
    private static final String SERVER_ERROR = "500";

    @GetMapping("/notfound")
    public ModelAndView returnNOtFound(){
        ModelAndView mav = new ModelAndView(NOT_FOUND);
        return mav;
    }

    @GetMapping("/servererror")
    public ModelAndView serverError(){
        ModelAndView mav = new ModelAndView(SERVER_ERROR);
        return mav;
    }

}
