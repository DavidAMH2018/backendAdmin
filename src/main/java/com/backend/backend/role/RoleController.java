/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.role;

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
@RequestMapping(path = "api/" + Const.VERSION + "/role")
   
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    
    @GetMapping
    public ResponseEntity<Object> getRole(@Nullable @RequestParam("param") String param) {
        return this.roleService.get(param);
    };
    
    @PostMapping
    public ResponseEntity<Object> newRole(@RequestBody String data){
        return this.roleService.post(data);
    }
    
    @PutMapping
    public ResponseEntity<Object> updateRole(@RequestBody String data){
        return this.roleService.put(data);
    }

}
