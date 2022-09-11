package com.udemy.springninja.service.Impl;

import com.udemy.springninja.controller.CourseController;
import com.udemy.springninja.entity.Course;
import com.udemy.springninja.repository.CourseJpaRepository;
import com.udemy.springninja.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    @Qualifier("courseJpaRepository")
    CourseJpaRepository courseJpaRepository;

    private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);


    @Override
    public List<Course> listAllCourses() {
        LOG.info("Call: listAllCourses()");
        return courseJpaRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        LOG.info("Call: addCourse()");
        return courseJpaRepository.save(course);
    }

    @Override
    public void removeCourse(int id) {
        courseJpaRepository.deleteById(id);
    }

    @Override
    public Course editCourse(Course course) {
        return courseJpaRepository.save(course);
    }
}
