package com.api.vtv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InspectorDTO {
    private Integer idPerson;
    private String name;
    private String lastName;
    private String dni;
    private String address;
    private String phone;
    private String specialty;
}
