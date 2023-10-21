/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.typerequest;

import com.backend.backend.request.Request;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Administrador
 */

@Entity
@Table(name = "TIPOSOLICITUD")

public class TypeRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoSolicitud")
    private Long idTipoSolicitud;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "status", columnDefinition = "integer default 0")
    private int status = 0;
    @OneToMany(mappedBy = "typeRequest")
    private List<Request> requests;
    
    public TypeRequest() {}
    
    public TypeRequest(Long idTipoSolicitud, String nombre, String descripcion) {
        this.idTipoSolicitud = idTipoSolicitud;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public TypeRequest(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void setIdTipoSolicitud(Long idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdTipoSolicitud() {
        return idTipoSolicitud;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public int getStatus() {
        return status;
    }
}
