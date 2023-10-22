/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.request;

import com.backend.backend.employee.Employee;
import com.backend.backend.status.Status;
import com.backend.backend.typerequest.TypeRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
/**
 *
 * @author Administrador
 */

@Entity
@Table(name = "SOLICITUD")

public class Request {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSolicitud")
    private Long idSolicitud;
    @Column(name = "idTipoSolicitud")
    private int idTipoSolicitud;
    @Column(name = "idEmpleador")
    private int idEmpleador;
    @Column(name = "idJefe")
    private int idJefe;
    @Column(name = "fechaInicial")
    private Date fechaInicial;
    @Column(name = "fechaFinal")
    private Date fechaFinal;
    @Column(name = "totalDias")
    private int totalDias; 
    @Column(name = "totalHoras")
    private int totalHoras;
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "idEstado", columnDefinition = "int default 1")
    private int idEstado = 1;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpleador", referencedColumnName = "idEmpleador", insertable = false, updatable = false)
    private Employee creator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idJefe", referencedColumnName = "idEmpleador", insertable = false, updatable = false)
    private Employee assignedTo;
    
    @ManyToOne
    @JoinColumn(name = "idTipoSolicitud", referencedColumnName = "idTipoSolicitud", insertable = false, updatable = false)
    private TypeRequest typeRequest;
    
    @ManyToOne
    @JoinColumn(name = "idEstado", referencedColumnName = "idEstado", insertable = false, updatable = false)
    private Status status;

    
    public Request(){}
    
    public Request(Long idSolicitud, int idEmpleador, int idJefe, Date fechaInicial, Date fechaFinal, int totalDias, int totalHoras, String observacion, int idEstado, TypeRequest typeRequest, int idTipoSolicitud) {
        this.idSolicitud = idSolicitud;
        this.idEmpleador = idEmpleador;
        this.idJefe = idJefe;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.totalDias = totalDias;
        this.totalHoras = totalHoras;
        this.observacion = observacion;
        this.idEstado = idEstado;
        this.idTipoSolicitud = idTipoSolicitud;
        this.typeRequest = typeRequest;
    }

    public Request(int idEmpleador, int idJefe, Date fechaInicial, Date fechaFinal, int totalDias, int totalHoras, String observacion, int idEstado, int idTipoSolicitud) {
        this.idEmpleador = idEmpleador;
        this.idJefe = idJefe;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.totalDias = totalDias;
        this.totalHoras = totalHoras;
        this.observacion = observacion;
        this.idEstado = idEstado;
        this.idTipoSolicitud = idTipoSolicitud;
    }
    
    public void setIdSolicitud(Long idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public void setIdEmpleador(int idEmpleador) {
        this.idEmpleador = idEmpleador;
    }

    public void setIdJefe(int idJefe) {
        this.idJefe = idJefe;
    }
    
    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public void setTotalDias(int totalDias) {
        this.totalDias = totalDias;
    }

    public void setTotalHoras(int totalHoras) {
        this.totalHoras = totalHoras;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public void setIdTipoSolicitud(int idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }
    
    public Long getIdSolicitud() {
        return idSolicitud;
    }

    public int getIdEmpleador() {
        return idEmpleador;
    }

    public int getIdJefe() {
        return idJefe;
    }
   
    public Date getFechaInicial() {
        return fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public int getTotalDias() {
        return totalDias;
    }

    public int getTotalHoras() {
        return totalHoras;
    }

    public String getObservacion() {
        return observacion;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public int getIdTipoSolicitud() {
        return idTipoSolicitud;
    }
}
