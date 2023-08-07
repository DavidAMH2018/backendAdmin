/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.position;

/**
 *
 * @author Administrador
 */
public class PositionExtendedDTO {

    private Long idCargo;
    private String Descripcion;
    private int status = 0;
    private String area;
    
    public PositionExtendedDTO(){}
    
    public PositionExtendedDTO(Long idCargo, String Descripcion, String area) {
        this.idCargo = idCargo;
        this.Descripcion = Descripcion;
        this.area = area;
    }

    public void setIdCargo(Long idCargo) {
        this.idCargo = idCargo;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Long getIdCargo() {
        return idCargo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public int getStatus() {
        return status;
    }

    public String getArea() {
        return area;
    }
    
    
}
