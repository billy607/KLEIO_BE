package com.kleio.app.dao;

import com.kleio.app.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{

    private static List<Person> DB = new ArrayList<>();

    @Override
    public boolean insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return true;
    }

    @Override
    public List<Person> getAllPeople() {
        return DB;
    }
}
