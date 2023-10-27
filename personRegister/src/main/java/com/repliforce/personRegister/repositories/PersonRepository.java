package com.repliforce.personRegister.repositories;

import com.repliforce.personRegister.data.vo.v1.PersonVO;
import com.repliforce.personRegister.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonVO, Long> {
}
