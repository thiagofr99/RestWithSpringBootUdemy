package com.devthiagofurtado.controller;

import com.devthiagofurtado.data.vo.PersonVO;
import com.devthiagofurtado.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Api(value = "Person Endpoint", description = "Description for person", tags = {"Person Endpoint"})
@RestController
@RequestMapping("api/person/v1")
public class PersonController {

    @Autowired
    private PersonService personService;

    @ApiOperation(value = "Buscar Person por Id.")
    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public PersonVO buscarPorId(@PathVariable(value = "id") Long id) {
        PersonVO personVO = personService.findById(id);
        personVO.add(linkTo(methodOn(PersonController.class).buscarPorId(id)).withSelfRel());
        return personVO;
    }

    @ApiOperation(value = "Buscar todos registros de Person.")
    @GetMapping(value = {}, produces = {"application/json", "application/xml", "application/x-yaml"})
    public Page<PersonVO> buscarTodos(@RequestParam(value = "page", defaultValue = "0") int page,
                                      @RequestParam(value = "limit", defaultValue = "12") int limit,
                                      @RequestParam(value = "direction", defaultValue = "ASC") String direction
                                      ) {

        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC: Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page,limit);

        Page<PersonVO> personVOS = personService.findAll(pageable);
        personVOS.forEach(p -> {
            p.add(linkTo(methodOn(PersonController.class).buscarPorId(p.getKey())).withSelfRel());
        });
        return personVOS;
    }

    @ApiOperation(value = "Cria um registro de Person.")
    @PostMapping(value = "/salvar", produces = {"application/json", "application/xml", "application/x-yaml"}
            , consumes = {"application/json", "application/xml", "application/x-yaml"})
    public PersonVO salvar(@RequestBody PersonVO person) {
        PersonVO personVO = personService.create(person);
        personVO.add(linkTo(methodOn(PersonController.class).buscarPorId(personVO.getKey())).withSelfRel());
        return personVO;
    }

    @ApiOperation(value = "Atualiza um registro de Person.")
    @PutMapping(value = "/atualizar", produces = {"application/json", "application/xml", "application/x-yaml"}
            , consumes = {"application/json", "application/xml", "application/x-yaml"})
    public PersonVO atualizar(@RequestBody PersonVO person) {
        PersonVO personVO = personService.update(person);
        personVO.add(linkTo(methodOn(PersonController.class).buscarPorId(personVO.getKey())).withSelfRel());
        return personVO;
    }

    @ApiOperation(value = "Deleta um registro de Person.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        personService.delete(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Desabilita um registro de Person.")
    @PatchMapping("/{id}")
    public ResponseEntity<PersonVO> desabilitar(@PathVariable(value = "id") Long id) {
        personService.desabilitar(id);
        PersonVO vo = personService.findById(id);
        vo.add(linkTo(methodOn(PersonController.class).buscarPorId(vo.getKey())).withSelfRel());
        return new ResponseEntity<>(vo, HttpStatus.OK);
    }

}
