/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.typerequest;

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
public class TypeRequestService {
    private final TypeRequestRepository typeRequestRepository;
    
    public TypeRequestService(TypeRequestRepository typeRequestRepository) {
        this.typeRequestRepository = typeRequestRepository;
    }
    
    public ResponseEntity<Object> get(String param) {
        return new ResponseEntity<>(
            Utils.respOk(this.typeRequestRepository.findAll()),
            HttpStatus.OK
        );   
    };
    
    public ResponseEntity<Object> post(String data){
        TypeRequest typeRequest = Utils.getData(data, TypeRequest.class);

        this.typeRequestRepository.save(typeRequest);
        
        return new ResponseEntity<>(
               Utils.respMsg(LangCode.msg_create_typerequest ),
               HttpStatus.OK
        );
    }
    
    public ResponseEntity<Object> put(String data){
        TypeRequest typeRequest = Utils.getData(data, TypeRequest.class);
        
        if(typeRequest.getIdTipoSolicitud() == null){
            return new ResponseEntity<>(
               Utils.respError(null, LangCode.msg_id_vacio ),
               HttpStatus.OK
            );
        }
        
        this.typeRequestRepository.save(typeRequest);
        
        return new ResponseEntity<>(
               Utils.respMsg(LangCode.msg_update_typerequest ),
               HttpStatus.OK
        );
    }
}
