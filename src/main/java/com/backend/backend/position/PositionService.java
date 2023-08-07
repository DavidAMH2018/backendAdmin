/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.position;

import com.backend.backend.utils.Utils;
import com.backend.backend.utils.LangCode;
import static com.backend.backend.utils.Utils.respError;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */

@Service
public class PositionService {
    
    private final PositionRepository positionRepository;
    
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }
    
    public ResponseEntity<Object> get(String param) {
        List<Position> res = null;
        if(param == null){
            List<Object[]> results = positionRepository.findAllPositionsWithAreas();
            List<PositionDTO> positionDTOs = results.stream().map(result -> {
                Position position = (Position) result[0];
                String descripcion = (String) result[1];

                PositionExtendedDTO dto = new PositionExtendedDTO();
                dto.setIdCargo(position.getIdCargo());
                dto.setDescripcion(position.getDescripcion());
                dto.setArea(descripcion);

                return new PositionDTO(position, dto);
            }).collect(Collectors.toList());

            return new ResponseEntity<>(
                Utils.respOk(positionDTOs),
                HttpStatus.OK
        );
        }else{
            String paramDecode = Utils.getBase64(param);
            String[] parts = paramDecode.split(":");
            switch (parts[0]) { 
                case "idEstado" -> {
                   res =  this.positionRepository.findPositionBystatus(Integer.parseInt(parts[1]));
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
        Position position = Utils.getData(data, Position.class);

        this.positionRepository.save(position);
        
        return new ResponseEntity<>(
               Utils.respMsg(LangCode.msg_create_position ),
               HttpStatus.OK
        );
    }
    
    public ResponseEntity<Object> put(String data){
        Position position = Utils.getData(data, Position.class);
        
        if(position.getIdCargo() == null){
            return new ResponseEntity<>(
               Utils.respError(null, LangCode.msg_id_vacio ),
               HttpStatus.OK
            );
        }
        
        this.positionRepository.save(position);
        
        return new ResponseEntity<>(
               Utils.respMsg(LangCode.msg_update_position ),
               HttpStatus.OK
        );
    }
    
}
