/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.status;

import com.backend.backend.utils.Const;
import io.micrometer.common.lang.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin("*")
@RestController
@RequestMapping(path = "api/" + Const.VERSION + "/status")

public class StatusController {
    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }
    
    @GetMapping
    public ResponseEntity<Object> getStatus(@Nullable @RequestParam("param") String param) {
        return this.statusService.get(param);
    };
    
    @PostMapping
    public ResponseEntity<Object> newStatus(@RequestBody String data){
        return this.statusService.post(data);
    }
    
    @PutMapping
    public ResponseEntity<Object> updateStatus(@RequestBody String data){
        return this.statusService.put(data);
    }
}
