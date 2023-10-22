package com.repliforce.personRegister.services;

import com.repliforce.personRegister.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong idGenerator = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            Person person = mockPerson(i);
            personList.add(person);
        }
        return personList;
    }

    public Person findById(String id){

        logger.info("Looking all people...");

        Person person = new Person();
        person.setId(idGenerator.incrementAndGet());
        person.setFirstName("Ayame");
        person.setLastName("Hinode");
        person.setAddress("UnitedStates");
        person.setGender("Female");
        return person;

    }

    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(idGenerator.incrementAndGet());
        person.setFirstName("Name" + i);
        person.setLastName("Last name" + 1);
        person.setAddress("Place" + i);
        person.setGender("Female");
        return person;

    }

}
