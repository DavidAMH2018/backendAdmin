/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.user;

import com.backend.backend.utils.Const;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrador
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "api/" + Const.VERSION + "/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping
    public ResponseEntity<Object> getUsers() {
        return this.userService.get();
    };
    
    @PostMapping
    public ResponseEntity<Object> newUser(@RequestBody String data){
        return this.userService.post(data);
    }
    
    @PostMapping(path = "/login")
    public ResponseEntity<Object> loginUser(@RequestBody String data){
        return this.userService.login(data);
    }
    
    @PutMapping
    public ResponseEntity<Object> updateUser(@RequestBody String data){
        return this.userService.put(data);
    }
}
