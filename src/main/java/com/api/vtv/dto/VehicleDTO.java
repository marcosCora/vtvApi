package com.api.vtv.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO {

    private Integer idVehicle;
    private String brand;
    private String model;
    private String domain;
    private Date expirationVtv;
    private String dniOwner;

}
