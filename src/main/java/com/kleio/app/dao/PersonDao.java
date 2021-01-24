package com.kleio.app.dao;

import com.kleio.app.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonDao {

    boolean insertPerson(UUID id, Person person);

    default boolean insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> getAllPeople();
}
