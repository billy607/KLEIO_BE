package com.kleio.app.service;

import com.kleio.app.dao.PersonDao;
import com.kleio.app.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

    @Autowired
    @Qualifier("fakeDao")
    private final PersonDao personDao;

    public boolean addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.getAllPeople();
    }
}
