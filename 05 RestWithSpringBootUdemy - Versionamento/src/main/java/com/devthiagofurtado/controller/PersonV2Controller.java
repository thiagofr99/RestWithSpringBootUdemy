package com.devthiagofurtado.controller;

import com.devthiagofurtado.data.model.Person;
import com.devthiagofurtado.data.vo.PersonVO;
import com.devthiagofurtado.data.vo2.PersonVO2;
import com.devthiagofurtado.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person/v2")
public class PersonV2Controller {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public PersonVO2 buscarPorId(@PathVariable(value = "id") Long id) {
        return personService.findByIdV2(id);
    }

    @GetMapping()
    public List<PersonVO2> buscarTodos() {
        return personService.findAllV2();
    }

    @PostMapping("/salvar")
    public PersonVO2 salvar(@RequestBody PersonVO2 person) {
        return personService.createV2(person);
    }

    @PutMapping("/atualizar")
    public PersonVO2 atualizar(@RequestBody Person person) {
        return personService.updateV2(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        personService.delete(id);
        return ResponseEntity.ok().build();
    }

}
