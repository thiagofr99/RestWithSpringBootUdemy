package com.devthiagofurtado.service;

import com.devthiagofurtado.converter.DozerConverter;
import com.devthiagofurtado.converter.SimpleConverter;
import com.devthiagofurtado.data.model.Person;
import com.devthiagofurtado.data.vo.PersonVO;
import com.devthiagofurtado.data.vo2.PersonVO2;
import com.devthiagofurtado.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonVO create(PersonVO person) {

        return DozerConverter.parseObject(personRepository.save(DozerConverter.parseObject(person,Person.class)), PersonVO.class);
    }

    public PersonVO2 createV2(PersonVO2 person) {
        return SimpleConverter.converterEntityToVo02(personRepository.save(DozerConverter.parseObject(person,Person.class)));
    }

    public PersonVO update(Person person) {
        Person personAntigo = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person não localizado."));
        personAntigo.setAddress(person.getAddress());
        personAntigo.setFirstName(person.getFirstName());
        personAntigo.setLastName(person.getLastName());
        personAntigo.setGender(person.getGender());

        return DozerConverter.parseObject(personRepository.save(personAntigo), PersonVO.class);
    }

    public PersonVO2 updateV2(Person person) {
        Person personAntigo = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person não localizado."));
        personAntigo.setAddress(person.getAddress());
        personAntigo.setFirstName(person.getFirstName());
        personAntigo.setLastName(person.getLastName());
        personAntigo.setGender(person.getGender());

        return SimpleConverter.converterEntityToVo02(personRepository.save(personAntigo));
    }

    public void delete(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person não localizado."));
        personRepository.delete(person);
    }

    public PersonVO findById(Long id) {
        return DozerConverter.parseObject(personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person não localizado.")), PersonVO.class);
    }

    public PersonVO2 findByIdV2(Long id) {
        return SimpleConverter.converterEntityToVo02(personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person não localizado.")));
    }

    public List<PersonVO> findAll() {
        return DozerConverter.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public List<PersonVO2> findAllV2() {
        return personRepository.findAll().stream().map(SimpleConverter::converterEntityToVo02).collect(Collectors.toList());
    }
}