/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Administrador
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserBycorreoElectronico(String correoElectronico);
    Optional<User> findEmployeeByCorreoElectronicoAndStatus(String correoElectronico, int status);
    Optional<User> findEmployeeByCorreoElectronicoAndContrasenaAndStatus(String correoElectronico, String contrasena, int status);
}
