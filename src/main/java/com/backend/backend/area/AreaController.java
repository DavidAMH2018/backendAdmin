/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.area;

import com.backend.backend.utils.Const;
import io.micrometer.common.lang.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Administrador
 */

@RestController
@RequestMapping(path = "api/" + Const.VERSION + "/area")
public class AreaController {
    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }
    
    @GetMapping
    public ResponseEntity<Object> getArea(@Nullable @RequestParam("param") String param) {
        return this.areaService.get(param);
    };
    
    @PostMapping
    public ResponseEntity<Object> newArea(@RequestBody String data){
        return this.areaService.post(data);
    }
    
    @PutMapping
    public ResponseEntity<Object> updateArea(@RequestBody String data){
        return this.areaService.put(data);
    }
}
