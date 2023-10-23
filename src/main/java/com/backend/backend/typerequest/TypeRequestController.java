/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.typerequest;

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
@RequestMapping(path = "api/" + Const.VERSION + "/typerequest")
public class TypeRequestController {
    private final TypeRequestService typeRequestService;

    public TypeRequestController(TypeRequestService typeRequestService) {
        this.typeRequestService = typeRequestService;
    }
    
    @GetMapping
    public ResponseEntity<Object> getTypeRequest(@Nullable @RequestParam("param") String param) {
        return this.typeRequestService.get(param);
    };
    
    @PostMapping
    public ResponseEntity<Object> newTypeRequest(@RequestBody String data){
        return this.typeRequestService.post(data);
    }
    
    @PutMapping
    public ResponseEntity<Object> updateTypeRequest(@RequestBody String data){
        return this.typeRequestService.put(data);
    }
}
