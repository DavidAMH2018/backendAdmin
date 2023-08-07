/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Administrador
 */

@Entity
@Table(name = "ROLES")

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol")
    private Long idRol;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "permisos")
    private String permisos;

    
    public Role() {}
    
    public Role(Long idRol, String nombre, String permisos) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.permisos = permisos;
    }

    public Role(String nombre, String permisos) {
        this.nombre = nombre;
        this.permisos = permisos;
    }
    
    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    public Long getIdRol() {
        return idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPermisos() {
        return permisos;
    }
}
