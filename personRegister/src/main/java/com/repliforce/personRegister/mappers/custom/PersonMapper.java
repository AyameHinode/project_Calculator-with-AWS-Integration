package com.repliforce.personRegister.mappers.custom;

import com.repliforce.personRegister.data.vo.v1.PersonVO;
import com.repliforce.personRegister.data.vo.v2.PersonVOv2;
import com.repliforce.personRegister.model.Person;

import java.util.Date;

public class PersonMapper {

    public PersonVOv2 convertEntityToVo(Person person){
        PersonVOv2 personV2 = new PersonVOv2();
        personV2.setId(person.getId());
        personV2.setAddress(person.getAddress());
        personV2.setFirstName(person.getFirstName());
        personV2.setLastName(person.getLastName());
        personV2.setGender(person.getGender());
        personV2.setBirthday(new Date());
        return personV2;
    }

    public Person convertEntityToVo(PersonVOv2 personV2){
        Person person = new Person();
        person.setId(personV2.getId());
        person.setAddress(personV2.getAddress());
        person.setFirstName(personV2.getFirstName());
        person.setLastName(personV2.getLastName());
        person.setGender(personV2.getGender());
        return person;
    }

}
