package com.udemy.springninja.service;

import com.udemy.springninja.entity.Course;
import com.udemy.springninja.model.CourseModel;

import java.util.List;

public interface CourseService {

    public abstract List<Course> listAllCourses();

    public abstract Course addCourse(Course course);

    public abstract void removeCourse(int id);

    public abstract Course editCourse(Course course);

    public abstract void deleteCourse(int id);

    public abstract Course updateCourse(int id, CourseModel course);


}
