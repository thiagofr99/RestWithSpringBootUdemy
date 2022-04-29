package com.devthiagofurtado.controller;

import com.devthiagofurtado.data.model.Person;
import com.devthiagofurtado.data.vo.PersonVO;
import com.devthiagofurtado.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/person/v1")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public PersonVO buscarPorId(@PathVariable(value = "id") Long id) {
        return personService.findById(id);
    }

    @GetMapping(value = {}, produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<PersonVO> buscarTodos() {
        return personService.findAll();
    }

    @PostMapping(value = "/salvar", produces = {"application/json", "application/xml", "application/x-yaml"}
            , consumes = {"application/json", "application/xml", "application/x-yaml"})
    public PersonVO salvar(@RequestBody PersonVO person) {
        return personService.create(person);
    }

    @PutMapping( value = "/atualizar", produces = {"application/json", "application/xml", "application/x-yaml"}
            , consumes = {"application/json", "application/xml", "application/x-yaml"})
    public PersonVO atualizar(@RequestBody Person person) {
        return personService.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        personService.delete(id);
        return ResponseEntity.ok().build();
    }

}
