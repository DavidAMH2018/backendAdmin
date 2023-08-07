/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.area;

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
public class AreaService {
    private final AreaRepository areaRepository;
    
    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }
    
    public ResponseEntity<Object> get(String param) {
        List<Area> res = null;
        if(param == null){
            return new ResponseEntity<>(
            Utils.respOk(this.areaRepository.findAll()),
            HttpStatus.OK
        );
        }else{
            String paramDecode = Utils.getBase64(param);
            String[] parts = paramDecode.split(":");
            switch (parts[0]) { 
                case "idEstado" -> {
                   res =  this.areaRepository.findAreaBystatus(Integer.parseInt(parts[1]));
                }
                default -> res = null;
            }
            
            return new ResponseEntity<>(
                Utils.respOk(res),
                HttpStatus.OK
            );
        }  
    };
    
    public ResponseEntity<Object> post(String data){
        Area area = Utils.getData(data, Area.class);
        
        this.areaRepository.save(area);
        
        return new ResponseEntity<>(
               Utils.respMsg(LangCode.msg_create_area ),
               HttpStatus.OK
        );
    }
    
    public ResponseEntity<Object> put(String data){
        Area area = Utils.getData(data, Area.class);
        
        if(area.getIdArea() == null){
            return new ResponseEntity<>(
               Utils.respError(null, LangCode.msg_id_vacio ),
               HttpStatus.OK
            );
        }
        
        this.areaRepository.save(area);
        
        return new ResponseEntity<>(
               Utils.respMsg(LangCode.msg_update_area ),
               HttpStatus.OK
        );
    }
}
