package com.devthiagofurtado.data.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "address", "firstName", "lastName", "gender"})
public class PersonVO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String gender;

}
