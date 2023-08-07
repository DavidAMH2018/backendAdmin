/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.request;

import java.util.List;
import java.util.Optional;
import org.apache.coyote.RequestInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 */

@Repository
public interface RequestRepository  extends JpaRepository<Request, Long> {
    List<Request> findRequestByidEmpleador(int idEmpleador);
    List<Request> findRequestByidJefe(int idJefe);
    @Query("SELECT r, tr.nombre, CONCAT(e1.nombre, ' ', e1.apellidos), CONCAT(e2.nombre, ' ', e2.apellidos), s.descripcion " +
           "FROM Request r " +
           "LEFT JOIN TypeRequest tr ON r.idTipoSolicitud = tr.idTipoSolicitud " +
           "LEFT JOIN Employee e1 ON r.idEmpleador = e1.idEmpleador " +
           "LEFT JOIN Employee e2 ON r.idJefe = e2.idEmpleador " + 
           "LEFT JOIN Status s ON r.idEstado = s.idEstado ORDER BY r.idSolicitud DESC")
    List<Object[]> getAllRequestsInfoWithJoin();
    @Query("SELECT r, tr.nombre, CONCAT(e1.nombre, ' ', e1.apellidos), CONCAT(e2.nombre, ' ', e2.apellidos), s.descripcion " +
       "FROM Request r " +
       "LEFT JOIN TypeRequest tr ON r.idTipoSolicitud = tr.idTipoSolicitud " +
       "LEFT JOIN Employee e1 ON r.idEmpleador = e1.idEmpleador " +
       "LEFT JOIN Employee e2 ON r.idJefe = e2.idEmpleador " +
       "LEFT JOIN Status s ON r.idEstado = s.idEstado " +
       "WHERE (:idEmployer IS NULL OR r.idEmpleador = :idEmployer) ORDER BY r.idSolicitud DESC")
    List<Object[]> getAllRequestsInfoWithEmployerFilter(@Param("idEmployer") int idEmployer);

    @Query("SELECT r, tr.nombre, CONCAT(e1.nombre, ' ', e1.apellidos), CONCAT(e2.nombre, ' ', e2.apellidos), s.descripcion " +
       "FROM Request r " +
       "LEFT JOIN TypeRequest tr ON r.idTipoSolicitud = tr.idTipoSolicitud " +
       "LEFT JOIN Employee e1 ON r.idEmpleador = e1.idEmpleador " +
       "LEFT JOIN Employee e2 ON r.idJefe = e2.idEmpleador " +
       "LEFT JOIN Status s ON r.idEstado = s.idEstado " +
       "WHERE (:idBoss IS NULL OR r.idJefe = :idBoss) ORDER BY r.idSolicitud DESC")
    List<Object[]> getAllRequestsInfoWithBossFilter(@Param("idBoss") int idBoss);
}
