package com.kleio.app.api;

import com.kleio.app.model.Person;
import com.kleio.app.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/person")
@RestController
@AllArgsConstructor
public class PersonController {

    @Autowired
    private final PersonService personService;

    @PostMapping
    public boolean addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getPerson() {
        return personService.getAllPeople();
    }
}
