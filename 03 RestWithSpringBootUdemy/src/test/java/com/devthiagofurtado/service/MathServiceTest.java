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
class MathServiceTest {

    @InjectMocks
    private MathService mathService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void calcular_retornaDouble_sucessoSomar() {

        Double test = mathService.calcular("1,0","2,0", Operacao.SOMA);

        Assertions.assertThat(test).isNotNull();
        Assertions.assertThat(test).isEqualTo(3.0);

    }

    @Test
    void calcular_retornaDouble_sucessoSubtrair() {

        Double test = mathService.calcular("1,0","2,0", Operacao.SUBTRACAO);

        Assertions.assertThat(test).isNotNull();
        Assertions.assertThat(test).isEqualTo(-1.0);

    }

    @Test
    void calcular_retornaDouble_sucessoDividir() {

        Double test = mathService.calcular("1,0","2,0", Operacao.DIVISAO);

        Assertions.assertThat(test).isNotNull();
        Assertions.assertThat(test).isEqualTo(0.5);

    }

    @Test
    void calcular_retornaDouble_sucessoMultiplicar() {

        Double test = mathService.calcular("1,0","2,0", Operacao.MULTIPLICACAO);

        Assertions.assertThat(test).isNotNull();
        Assertions.assertThat(test).isEqualTo(2.0);

    }

    @Test
    void calcular_retornaDouble_sucessoMedia() {

        Double test = mathService.calcular("1,0","3,0", Operacao.MEDIA);

        Assertions.assertThat(test).isNotNull();
        Assertions.assertThat(test).isEqualTo(2.0);

    }

    @Test
    void calcular_retornaDouble_sucessoRaiz() {

        Double test = mathService.calcular("9,0",null, Operacao.RAIZ_QUADRADA);

        Assertions.assertThat(test).isNotNull();
        Assertions.assertThat(test).isEqualTo(3.0);

    }

    @Test
    void calcular_retornaUnsuportedMathOperationException_erroDigitoInvalido() {

        Assertions.assertThatThrownBy(()-> mathService.calcular("A","2,0", Operacao.MULTIPLICACAO))
                .isInstanceOf(UnsuportedMathOperationException.class);

    }

}