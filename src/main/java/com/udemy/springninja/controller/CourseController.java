package com.udemy.springninja.controller;

import com.udemy.springninja.converter.CourseConverter;
import com.udemy.springninja.entity.Course;
import com.udemy.springninja.model.CourseModel;
import com.udemy.springninja.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/course")
public class CourseController {

    private static final String COURSES_VIEW = "courses";

    private static final Log LOG = LogFactory.getLog(CourseController.class);

    @Autowired
    @Qualifier("courseService")
    private CourseService courseService;

    @GetMapping("/all")
    public ModelAndView listAllCourses(){
        LOG.info("Call " + "listAllCourses()");
        ModelAndView mav = new ModelAndView(COURSES_VIEW);
        mav.addObject("course",new Course());
        mav.addObject("courses",courseService.listAllCourses());
        return mav;
    }


    @PostMapping("/add")
    public String addCourse(@ModelAttribute("course") Course course){
        LOG.info("Call " + "addCourse()" + "-- PARAM: " + course.toString());
        courseService.addCourse(course);
        return "redirect:/course/all";
    }

    @PutMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") int id,@ModelAttribute("course") CourseModel course){
        LOG.info("Call " + "updateCourse()" + "-- ID:  " + id);
        courseService.updateCourse(id,course);
        return "redirect:/course/all";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") int id){
        LOG.info("Call " + "deleteCourse()" + "-- ID:  " + id);
        courseService.deleteCourse(id);
        return "redirect:/course/all";
    }


}
