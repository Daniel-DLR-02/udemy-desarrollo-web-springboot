package com.udemy.springninja.service.Impl;

import com.udemy.springninja.model.Person;
import com.udemy.springninja.service.ExampleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

    private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

    @Override
    public List<Person> getListPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Miguel",13));
        people.add(new Person("Juan",20));
        people.add(new Person("Julia",19));
        people.add(new Person("Manuel",23));
        LOG.info("HELLO FROM SERVICE");
        return people;
    }
}
