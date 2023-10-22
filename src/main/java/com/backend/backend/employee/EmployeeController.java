/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.employee;

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
@RequestMapping(path = "api/" + Const.VERSION + "/employee")
public class EmployeeController {
   private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    /*@GetMapping
    public ResponseEntity<Object> getEmployee() {
        return this.employeeService.get();
    };*/
    
    @GetMapping
    public ResponseEntity<Object> getEmployeeByParams(@Nullable @RequestParam("param") String param) {
        return this.employeeService.getByParams(param);
    };
    
    @PostMapping
    public ResponseEntity<Object> newEmployee(@RequestBody String data){
        return this.employeeService.post(data);
    }
    
    @PostMapping(path = "/login")
    public ResponseEntity<Object> loginEmployee(@RequestBody String data){
        return this.employeeService.login(data);
    }
    
    
    @PutMapping
    public ResponseEntity<Object> updateEmployee(@RequestBody String data){
        return this.employeeService.put(data);
    }
     
}
