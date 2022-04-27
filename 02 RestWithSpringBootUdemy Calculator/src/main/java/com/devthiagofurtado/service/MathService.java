package com.devthiagofurtado.service;

import com.devthiagofurtado.enums.Operacao;
import com.devthiagofurtado.exception.UnsuportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double calcular(String numberOne, String numberTwo, Operacao operation) {
        switch (operation) {
            case SOMA:
                return somar(numberOne, numberTwo);
            case DIVISAO:
                return dividir(numberOne, numberTwo);
            case SUBTRACAO:
                return subtrair(numberOne, numberTwo);
            case MULTIPLICACAO:
                return multiplicar(numberOne, numberTwo);
            case MEDIA:
                return media(numberOne, numberTwo);
            case RAIZ_QUADRADA:
                return raiz(numberOne);
            default:
                throw new UnsuportedMathOperationException("Selecionar operação válida.");
        }


    }

    private Double somar(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set numeric value.");
        }

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private Double subtrair(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set numeric value.");
        }

        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    private Double dividir(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set numeric value.");
        }

        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    private Double multiplicar(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set numeric value.");
        }

        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    private Double media(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set numeric value.");
        }

        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2D;
    }

    private Double raiz(String numberOne) {
        if (!isNumeric(numberOne)) {
            throw new UnsuportedMathOperationException("Please set numeric value.");
        }

        return Math.sqrt(convertToDouble(numberOne));
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

}
