/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.status;

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
public class StatusService {
    private final StatusRepository statusRepository;
    
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }
    
    public ResponseEntity<Object> get(String param) {
         return new ResponseEntity<>(
            Utils.respOk(this.statusRepository.findAll()),
            HttpStatus.OK
        );    
    };
    
    public ResponseEntity<Object> post(String data){
        Status status = Utils.getData(data, Status.class);

        this.statusRepository.save(status);
        
        return new ResponseEntity<>(
               Utils.respMsg(LangCode.msg_create_status ),
               HttpStatus.OK
        );
    }
    
    public ResponseEntity<Object> put(String data){
        Status status = Utils.getData(data, Status.class);
        
        if(status.getIdEstado() == null){
            return new ResponseEntity<>(
               Utils.respError(null, LangCode.msg_id_vacio ),
               HttpStatus.OK
            );
        }
        
        this.statusRepository.save(status);
        
        return new ResponseEntity<>(
               Utils.respMsg(LangCode.msg_update_status ),
               HttpStatus.OK
        );
    }
}
