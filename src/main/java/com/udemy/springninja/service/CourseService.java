package com.udemy.springninja.service;

import com.udemy.springninja.entity.Course;

import java.util.List;

public interface CourseService {

    public abstract List<Course> listAllCourses();

    public abstract Course addCourse(Course course);

    public abstract void removeCourse(int id);

    public abstract Course editCourse(Course course);

}
