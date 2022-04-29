package com.devthiagofurtado.data.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonVO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String gender;

}
