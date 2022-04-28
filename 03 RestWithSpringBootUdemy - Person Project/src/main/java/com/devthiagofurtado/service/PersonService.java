package com.devthiagofurtado.service;

import com.devthiagofurtado.model.Person;
import com.devthiagofurtado.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Person update(Person person) {
        Person personAntigo = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person não localizado."));
        personAntigo.setAddress(person.getAddress());
        personAntigo.setFirstName(person.getFirstName());
        personAntigo.setLastName(person.getLastName());
        personAntigo.setGender(person.getGender());

        return personRepository.save(personAntigo);
    }

    public void delete(Long id) {
        Person person = findById(id);
        personRepository.delete(person);
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person não localizado."));
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
