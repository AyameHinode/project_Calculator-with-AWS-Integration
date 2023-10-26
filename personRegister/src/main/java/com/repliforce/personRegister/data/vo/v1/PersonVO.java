package com.repliforce.personRegister.data.vo.v1;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
public class PersonVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    public PersonVO(){}

}
