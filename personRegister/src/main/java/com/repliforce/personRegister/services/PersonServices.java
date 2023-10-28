package com.repliforce.personRegister.services;

import com.repliforce.personRegister.data.vo.v1.PersonVO;
import com.repliforce.personRegister.model.Person;
import com.repliforce.personRegister.exceptions.ResourceNotFoundException;
import com.repliforce.personRegister.mappers.DozerMapper;

import com.repliforce.personRegister.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository personRepository;

    public List<PersonVO> findAll(){
        logger.info("Looking all registers");
        return DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id){

        logger.info("Looking register...");
        var person =  personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found"));
        return DozerMapper.parseObject(person,PersonVO.class);
    }

    public PersonVO create(PersonVO person){

        logger.info("Creating a register...");
        var entity = DozerMapper.parseObject(person,Person.class);
        var vo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;

    }

    public PersonVO update(PersonVO person){

        logger.info("Updating a register");
        var entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        var vo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;

    }

    public void delete(Long id){

        logger.info("Deleting a register");
        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found"));
        personRepository.delete(entity);

    }

}
