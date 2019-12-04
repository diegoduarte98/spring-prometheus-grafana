package com.example.springprometheusgrafana;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByIdadeGreaterThanEqual(Integer idade);

    Integer countByStatus(String status);
}
