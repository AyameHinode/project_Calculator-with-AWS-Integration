package com.repliforce.personRegister.services;

import com.repliforce.personRegister.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong idGenerator = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){

        logger.info("Looking for a person...");

        Person person = new Person();
        person.setId(idGenerator.incrementAndGet());
        person.setFirstName("Ayame");
        person.setLastName("Hinode");
        person.setAddress("UnitedStates");
        person.setGender("Female");
        return person;

    }

}
