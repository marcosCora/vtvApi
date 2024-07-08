package com.api.vtv.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "controles")
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Control {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idControl;
    private String descripcion;
    private String result;
}
