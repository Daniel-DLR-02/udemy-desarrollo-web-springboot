package com.udemy.springninja.converter;

import com.udemy.springninja.entity.Course;
import com.udemy.springninja.model.CourseModel;
import org.springframework.stereotype.Component;

@Component("CourseConverter")
public class CourseConverter {


    // Entity --> Model
    public CourseModel entityToModel(Course course){
        CourseModel courseModel = new CourseModel();
        courseModel.setName(course.getName());
        courseModel.setDescripcion(course.getDescription());
        courseModel.setHours(course.getHours());
        courseModel.setPrice(course.getPrice());
        return courseModel;
    }

    //Model --> Entity
    public Course modelToEntity(CourseModel courseModel){
        Course course = new Course();
        course.setName(courseModel.getName());
        course.setDescription(courseModel.getDescripcion());
        course.setHours(courseModel.getHours());
        course.setPrice(courseModel.getPrice());
        return course;
    }

}
