package com.nttdata.API_Clientes.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@Table(name="Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="nombre")
    private String nombre;
    @Column(name="apellidos")
    private String apellidos;
    @Column(name="fecha")
    private LocalDate fecha;

    @Column(name="dni")
    private String dni;
}
