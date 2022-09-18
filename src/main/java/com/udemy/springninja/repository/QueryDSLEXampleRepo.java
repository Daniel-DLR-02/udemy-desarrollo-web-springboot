package com.udemy.springninja.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.springninja.entity.Course;
import com.udemy.springninja.entity.QCourse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("queryDSLExampleRepo")
public class QueryDSLEXampleRepo {

    private QCourse qCourse = QCourse.course;

    @PersistenceContext
    private EntityManager em;

    public Course find(boolean exists){

        JPAQuery<Course> query = new JPAQuery<Course>(em);

        BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));

        if(exists){
            predicateBuilder.and(qCourse.id.eq(23));

        }else{
            predicateBuilder.or(qCourse.name.endsWith("OP"));
        }

        return query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();

    }
}
