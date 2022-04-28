package com.devthiagofurtado.data.vo2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonVO2 implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;

    private String firstName;

    private String lastName;

    private Date birthday;

    private String address;

    private String gender;

}
