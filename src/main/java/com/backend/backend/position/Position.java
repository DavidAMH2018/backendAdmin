/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.position;

import com.backend.backend.area.Area;
import com.backend.backend.employee.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Administrador
 */

@Entity
@Table(name = "CARGO")

public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCargo")
    private Long idCargo;
    @Column(name = "Descripcion")
    private String Descripcion;
    @Column(name = "status", columnDefinition = "integer default 0")
    private int status = 0;
    @Column(name = "idArea")
    private int idArea; 
    
    @ManyToOne // Many Positions can belong to one Area
    @JoinColumn(name = "idArea", referencedColumnName = "idArea", insertable = false, updatable = false) // This links the idArea column in Position to the idArea column in Area
    private Area area; // The associated Area for this Position
    
    @OneToMany(mappedBy = "position")
    private List<Employee> employees = new ArrayList<>();
    
    public Position() {}

    public Position(Long idCargo, String Descripcion, int status, int idArea) {
        this.idCargo = idCargo;
        this.Descripcion = Descripcion;
        this.status = status;
        this.idArea = idArea;
    }
    
    public Position(String Descripcion,int status, int idArea) {
        this.Descripcion = Descripcion;
        this.status = status;
        this.idArea = idArea;
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
    
    public void setIdArea(int idArea) {
        this.idArea = idArea;
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

    public int getIdArea() {
        return idArea;
    }
    
    
}
