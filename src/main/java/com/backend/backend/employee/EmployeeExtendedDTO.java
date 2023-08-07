/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.employee;

/**
 *
 * @author Administrador
 */
public class EmployeeExtendedDTO {
    private Long idEmpleador;
    private String nombre;
    private String apellidos;
    private String correoElectronico;
    private String contrasena;
    private int status;
    private String rol;
    private String descripcion;

    public EmployeeExtendedDTO(){}
    
    public EmployeeExtendedDTO(Long idEmpleador, String nombre, String apellidos, String correoElectronico, String contrasena, int status, String rol, String descripcion) {
        this.idEmpleador = idEmpleador;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.status = status;
        this.rol = rol;
        this.descripcion = descripcion;
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

    public void setRoleName(String roleName) {
        this.rol = roleName;
    }

    public void setJobDescription(String jobDescription) {
        this.descripcion = jobDescription;
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

    public int getStatus() {
        return status;
    }

    public String getRoleName() {
        return rol;
    }

    public String getJobDescription() {
        return descripcion;
    }
    
    
}
