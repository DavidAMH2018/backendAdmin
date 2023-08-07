/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.employee;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findEmployeeBycorreoElectronico(String correoElectronico);
    List<Employee> findEmployeeByidRol(int idRol);
    Optional<Employee> findEmployeeByCorreoElectronicoAndContrasenaAndStatus(String correoElectronico, String contrasena, int status);
    List<Employee> findEmployeeByidCargo(int idCargo);
     @Query("SELECT e, r.nombre AS rolename, p.Descripcion AS roledescription FROM Employee e " +
           "JOIN e.role r JOIN e.position p")
    List<Object[]> findAllEmployeesWithRoleAndPosition();
}
