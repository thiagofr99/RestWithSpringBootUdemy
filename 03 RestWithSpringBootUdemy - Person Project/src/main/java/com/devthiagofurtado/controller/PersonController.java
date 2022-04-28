package com.devthiagofurtado.controller;

import com.devthiagofurtado.model.Person;
import com.devthiagofurtado.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public Person buscarPorId(@PathVariable(value = "id") Long id) {
        return personService.findById(id);
    }

    @GetMapping()
    public List<Person> buscarTodos() {
        return personService.findAll();
    }

    @PostMapping("/salvar")
    public Person salvar(@RequestBody Person person) {
        return personService.create(person);
    }

    @PutMapping("/atualizar")
    public Person atualizar(@RequestBody Person person) {
        return personService.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        personService.delete(id);
        return ResponseEntity.ok().build();
    }

}
