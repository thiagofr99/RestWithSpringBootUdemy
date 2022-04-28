package com.devthiagofurtado.controller;

import com.devthiagofurtado.data.model.Person;
import com.devthiagofurtado.data.vo.PersonVO;
import com.devthiagofurtado.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public PersonVO buscarPorId(@PathVariable(value = "id") Long id) {
        return personService.findById(id);
    }

    @GetMapping()
    public List<PersonVO> buscarTodos() {
        return personService.findAll();
    }

    @PostMapping("/salvar")
    public PersonVO salvar(@RequestBody PersonVO person) {
        return personService.create(person);
    }

    @PutMapping("/atualizar")
    public PersonVO atualizar(@RequestBody Person person) {
        return personService.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        personService.delete(id);
        return ResponseEntity.ok().build();
    }

}
