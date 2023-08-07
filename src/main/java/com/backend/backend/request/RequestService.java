/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.request;

import com.backend.backend.utils.Utils;
import com.backend.backend.utils.LangCode;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class RequestService {
    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }
    
    public ResponseEntity<Object> get(String param) {
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        List<RequestDTO> res = null;
        if(param == null){
            List<Object[]> results = this.requestRepository.getAllRequestsInfoWithJoin();
            List<RequestDTO> requestDTOs = results.stream().map(result -> {
                Request request = (Request) result[0];
                String tipoSolicitud = (String) result[1];
                String nombreEmpleado = (String) result[2];
                String nombreJefe = (String) result[3];
                String estado = (String) result[4];
                
                String formattedDateFechaInicial = outputFormat.format(request.getFechaInicial());
                String formattedDateFechaFinal = outputFormat.format(request.getFechaFinal());

                RequestExtendedDTO dto = new RequestExtendedDTO();
                dto.setIdSolicitud(request.getIdSolicitud());
                dto.setFechaInicial(formattedDateFechaInicial);
                dto.setFechaFinal(formattedDateFechaFinal);
                dto.setTotalDias(request.getTotalDias());
                dto.setTotalHoras(request.getTotalHoras());
                dto.setObservacion(request.getObservacion());
                dto.setEstado(estado);
                dto.setTipoSolicitud(tipoSolicitud);
                dto.setNombreEmpleado(nombreEmpleado);
                dto.setNombreJefe(nombreJefe);
                

                return new RequestDTO(request, dto);
            }).collect(Collectors.toList());
            
             return new ResponseEntity<>(
                Utils.respOk(requestDTOs),
                HttpStatus.OK
            );
        }else{
            String paramDecode = Utils.getBase64(param);
            String[] parts = paramDecode.split(":");
            switch (parts[0]) { 
                case "idEmpleador" -> {
                    List<Object[]> results = this.requestRepository.getAllRequestsInfoWithEmployerFilter(Integer.parseInt(parts[1]));
                    List<RequestDTO> requestDTOs = results.stream().map(result -> {
                        Request request = (Request) result[0];
                        String tipoSolicitud = (String) result[1];
                        String nombreEmpleado = (String) result[2];
                        String nombreJefe = (String) result[3];
                        String estado = (String) result[4];
                        
                        String formattedDateFechaInicial = outputFormat.format(request.getFechaInicial());
                        String formattedDateFechaFinal = outputFormat.format(request.getFechaFinal());

                        RequestExtendedDTO dto = new RequestExtendedDTO();
                        dto.setIdSolicitud(request.getIdSolicitud());
                        dto.setFechaInicial(formattedDateFechaInicial);
                        dto.setFechaFinal(formattedDateFechaFinal);
                        dto.setTotalDias(request.getTotalDias());
                        dto.setTotalHoras(request.getTotalHoras());
                        dto.setObservacion(request.getObservacion());
                        dto.setEstado(estado);
                        dto.setTipoSolicitud(tipoSolicitud);
                        dto.setNombreEmpleado(nombreEmpleado);
                        dto.setNombreJefe(nombreJefe);
                        
                        
                        return new RequestDTO(request, dto);
                    }).collect(Collectors.toList());
                    
                    res = requestDTOs;
                }
                case "idJefe" -> {
                    List<Object[]> resultsJefe = this.requestRepository.getAllRequestsInfoWithBossFilter(Integer.parseInt(parts[1]));
                    List<RequestDTO> requestDTOsJefe = resultsJefe.stream().map(result -> {
                        Request request = (Request) result[0];
                        String tipoSolicitud = (String) result[1];
                        String nombreEmpleado = (String) result[2];
                        String nombreJefe = (String) result[3];
                        String estado = (String) result[4];
                        
                        String formattedDateFechaInicial = outputFormat.format(request.getFechaInicial());
                        String formattedDateFechaFinal = outputFormat.format(request.getFechaFinal());

                        RequestExtendedDTO dto = new RequestExtendedDTO();
                        dto.setIdSolicitud(request.getIdSolicitud());
                        dto.setFechaInicial(formattedDateFechaInicial);
                        dto.setFechaFinal(formattedDateFechaFinal);
                        dto.setTotalDias(request.getTotalDias());
                        dto.setTotalHoras(request.getTotalHoras());
                        dto.setObservacion(request.getObservacion());
                        dto.setEstado(estado);
                        dto.setTipoSolicitud(tipoSolicitud);
                        dto.setNombreEmpleado(nombreEmpleado);
                        dto.setNombreJefe(nombreJefe);
                        
                        
                        return new RequestDTO(request, dto);
                    }).collect(Collectors.toList());
                    
                    res = requestDTOsJefe;
                }
                default -> res = null;
            }
        }
         
        return new ResponseEntity<>(
            Utils.respOk(res),
            HttpStatus.OK
        );
    };

    public ResponseEntity<Object> post(String data){
        Request request = Utils.getData(data, Request.class);

        this.requestRepository.save(request);
        
        return new ResponseEntity<>(
               Utils.respMsg(LangCode.msg_create_request ),
               HttpStatus.OK
        );
    }
    
    public ResponseEntity<Object> put(String data){
        Request request = Utils.getData(data, Request.class);
        if(request.getIdSolicitud() == null){
            return new ResponseEntity<>(
               Utils.respError(null, LangCode.msg_id_vacio ),
               HttpStatus.OK
            );
        }

        this.requestRepository.save(request);
        
        return new ResponseEntity<>(
               Utils.respMsg(LangCode.msg_update_request ),
               HttpStatus.OK
        );
    }
}
