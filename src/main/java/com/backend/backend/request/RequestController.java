/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.request;

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

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "api/" + Const.VERSION + "/request")
public class RequestController {
    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }
    
    @GetMapping
    public ResponseEntity<Object> getRequest(@Nullable @RequestParam("param") String param) {
        return this.requestService.get(param);
    };
    
    @PostMapping
    public ResponseEntity<Object> newRequest(@RequestBody String data){
        return this.requestService.post(data);
    }
    
    @PutMapping
    public ResponseEntity<Object> updateRequest(@RequestBody String data){
        return this.requestService.put(data);
    }
}
