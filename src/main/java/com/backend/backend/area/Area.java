/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.area;

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
@Table(name = "AREA")

public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idArea")
    private Long idArea;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "status", columnDefinition = "integer default 0")
    private int status = 0;
    
    public Area(){}
    public Area(Long idArea, String Descripcion, int status) {
        this.idArea = idArea;
        this.descripcion = Descripcion;
        this.status = status;
    }
    
    public Area(String Descripcion, int status) {
        this.descripcion = Descripcion;
    }

    public void setIdArea(Long idArea) {
        this.idArea = idArea;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion = Descripcion;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public Long getIdArea() {
        return idArea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getStatus() {
        return status;
    }
}
