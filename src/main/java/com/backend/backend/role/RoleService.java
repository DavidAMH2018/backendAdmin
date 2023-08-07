/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.role;

import com.backend.backend.utils.Utils;
import com.backend.backend.utils.LangCode;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
/**
 *
 * @author Administrador
 */

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    
    public ResponseEntity<Object> get(String param) {
        return new ResponseEntity<>(
            Utils.respOk(this.roleRepository.findAll()),
            HttpStatus.OK
        );
    };
    
    public ResponseEntity<Object> post(String data){
        Role role = Utils.getData(data, Role.class);

        this.roleRepository.save(role);
        
        return new ResponseEntity<>(
               Utils.respMsg(LangCode.msg_create_rol ),
               HttpStatus.OK
        );
    }
    
    public ResponseEntity<Object> put(String data){
        Role role = Utils.getData(data, Role.class);
        
        if(role.getIdRol() == null){
            return new ResponseEntity<>(
               Utils.respError(null, LangCode.msg_id_vacio ),
               HttpStatus.OK
            );
        }
        
        this.roleRepository.save(role);
        
        return new ResponseEntity<>(
               Utils.respMsg(LangCode.msg_update_rol ),
               HttpStatus.OK
        );
    }
}
