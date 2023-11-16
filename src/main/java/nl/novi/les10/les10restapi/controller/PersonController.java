package nl.novi.les10.les10restapi.controller;

import nl.novi.les10.les10restapi.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private ArrayList<Person> persons = new ArrayList<>();

    @GetMapping
    public ResponseEntity<ArrayList<Person>> getAllPersons() {
        return new ResponseEntity<>(this.persons, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        this.persons.add(person);

        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person person) {
        if (id >= 0 && id < this.persons.size()) {
            this.persons.set(id, person);
            return new ResponseEntity<>(person, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
