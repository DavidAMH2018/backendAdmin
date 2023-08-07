/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.status;

import com.backend.backend.request.Request;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
/**
 *
 * @author Administrador
 */

@Entity
@Table(name = "ESTADO")

public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstado")
    private Long idEstado;
    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "status")
    private List<Request> requests;
    
    public Status() {}
    
    public Status(Long idEstado, String descripcion) {
        this.idEstado = idEstado;
        this.descripcion = descripcion;
    }
    
    public Status(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    } 

    public Long getIdEstado() {
        return idEstado;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
