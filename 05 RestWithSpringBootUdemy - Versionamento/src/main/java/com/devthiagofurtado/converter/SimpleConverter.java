package com.devthiagofurtado.converter;

import com.devthiagofurtado.data.model.Person;
import com.devthiagofurtado.data.vo2.PersonVO2;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SimpleConverter {

    public static PersonVO2 converterEntityToVo02(Person entity){

        return PersonVO2.builder()
                .lastName(entity.getLastName())
                .address(entity.getAddress())
                .firstName(entity.getFirstName())
                .birthday(new Date())
                .gender(entity.getGender())
                .id(entity.getId())
                .build();
    }
    public static Person converterVo02ToEntity(PersonVO2 entity){

        return Person.builder()
                .lastName(entity.getLastName())
                .address(entity.getAddress())
                .firstName(entity.getFirstName())
                .gender(entity.getGender())
                .id(entity.getId())
                .build();
    }
}
