package com.repliforce.personRegister.services;

import com.repliforce.personRegister.exceptions.ResourceNotFoundException;
import com.repliforce.personRegister.model.Person;
import com.repliforce.personRegister.repositories.PersonRepository;
import org.hibernate.type.SpecialOneToOneType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository personRepository;

    public List<Person> findAll(){
        logger.info("Looking all registers");
        return personRepository.findAll();
    }

    public Person findById(Long id){

        logger.info("Looking register...");

        Person person = new Person();
        person.setFirstName("Ayame");
        person.setLastName("Hinode");
        person.setAddress("UnitedStates");
        person.setGender("Female");
        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found"));

    }

    public Person create(Person person){

        logger.info("Creating a register...");
        return personRepository.save(person);

    }

    public Person update(Person person){

        logger.info("Updating a register");
        var entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return personRepository.save(person);

    }

    public void delete(Long id){

        logger.info("Deleting a register");
        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found"));
        personRepository.delete(entity);

    }

}
