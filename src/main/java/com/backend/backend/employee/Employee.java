/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.employee;

import com.backend.backend.position.Position;
import com.backend.backend.request.Request;
import com.backend.backend.role.Role;
import jakarta.persistence.CascadeType;
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
@Table(name = "EMPLEADOS")

public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpleador")
    private Long idEmpleador;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "correoElectronico")
    private String correoElectronico;
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "status", columnDefinition = "integer default 0")
    private int status = 0;
    @Column(name = "idRol")
    private int idRol = 0;
    @Column(name = "idCargo")
    private int idCargo; 
    
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Request> createdRequests = new ArrayList<>();

    @OneToMany(mappedBy = "assignedTo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Request> assignedRequests = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "idCargo", referencedColumnName = "idCargo", insertable = false, updatable = false) // This links to the idCargo column in the CARGO table
    private Position position;
    
    @ManyToOne
    @JoinColumn(name = "idRol", referencedColumnName = "idRol", insertable = false, updatable = false) // This links to the idRol column in the ROLES table
    private Role role;
    
    public Employee() {}

    public Employee(Long idEmpleador, String nombre, String apellidos, String correoElectronico, String contrasena, int status, int idRol, int idCargo) {
        this.idEmpleador = idEmpleador;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.status = status;
        this.idRol = idRol;
        this.idCargo = idCargo;
    }
    
    public Employee(String nombre, String apellidos, String correoElectronico, String contrasena, int status, int idRol, int idCargo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.status = status;
        this.idRol = idRol;
        this.idCargo = idCargo;
    }
    
    public Employee(String correoElectronico, String contrasena) {
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }
    
    public void setIdEmpleador(Long idEmpleador) {
        this.idEmpleador = idEmpleador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
     
    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public Long getIdEmpleador() {
        return idEmpleador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public int getIdRol() {
        return idRol;
    }
  
    public int getIdCargo() {
        return idCargo;
    }

    public int getStatus() {
        return status;
    }  
}
