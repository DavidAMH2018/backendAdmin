/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.request;

import java.util.Date;

/**
 *
 * @author Administrador
 */
public class RequestExtendedDTO {
    private Long idSolicitud;
    private String tipoSolicitud;
    private String nombreEmpleado;
    private String nombreJefe;
    private String estado;
    private String fechaInicial;
    private String fechaFinal;
    private int totalDias; 
    private int totalHoras;
    private String observacion;
    
   

    public RequestExtendedDTO() {
    }

    public RequestExtendedDTO(Long idSolicitud, String fechaInicial, String fechaFinal, int totalDias, int totalHoras, String observacion, String tipoSolicitud, String nombreEmpleado, String nombreJefe, String estado) {
        this.idSolicitud = idSolicitud;
        this.tipoSolicitud = tipoSolicitud;
        this.nombreEmpleado = nombreEmpleado;
        this.nombreJefe = nombreJefe;
        this.estado = estado;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.totalDias = totalDias;
        this.totalHoras = totalHoras;
        this.observacion = observacion;    
    }

    public void setIdSolicitud(Long idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public void setFechaFinal(String fechaFinal) {
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

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public void setNombreJefe(String nombreJefe) {
        this.nombreJefe = nombreJefe;
    }

    public Long getIdSolicitud() {
        return idSolicitud;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public String getFechaFinal() {
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

    public String getEstado() {
        return estado;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public String getNombreJefe() {
        return nombreJefe;
    }
    
    
}
