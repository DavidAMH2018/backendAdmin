/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.position;

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
@RequestMapping(path = "api/" + Const.VERSION + "/position")
public class PositionController {
    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }
    
    @GetMapping
    public ResponseEntity<Object> getPosition(@Nullable @RequestParam("param") String param) {
        return this.positionService.get(param);
    };
    
    @PostMapping
    public ResponseEntity<Object> newPosition(@RequestBody String data){
        return this.positionService.post(data);
    }
    
    @PutMapping
    public ResponseEntity<Object> updatePosition(@RequestBody String data){
        return this.positionService.put(data);
    }
}
