/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.area;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Administrador
 */
public interface AreaRepository extends JpaRepository<Area, Long> {
    List<Area> findAreaBystatus(int idEstado);
}
