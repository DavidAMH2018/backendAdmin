/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.position;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 */

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    @Query("SELECT p, a.descripcion FROM Position p JOIN Area a ON p.idArea = a.idArea")
    List<Object[]> findAllPositionsWithAreas();
    List<Position> findPositionBystatus(int idEstado);
}
