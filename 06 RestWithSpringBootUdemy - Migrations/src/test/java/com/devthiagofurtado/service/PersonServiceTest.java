package com.devthiagofurtado.service;

import com.devthiagofurtado.enums.Operacao;
import com.devthiagofurtado.exception.UnsuportedMathOperationException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @BeforeEach
    void setUp() {

    }

}