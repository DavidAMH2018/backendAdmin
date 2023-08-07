/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.employee;

import com.backend.backend.utils.Utils;
import com.backend.backend.utils.LangCode;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */

@Service
public class EmployeeService {
    
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    public ResponseEntity<Object> get() {
        return new ResponseEntity<>(
            Utils.respOk(this.employeeRepository.findAll()),
            HttpStatus.OK
        );
    };
    
    public ResponseEntity<Object> getByParams(String param) {
        if(param == null){
            List<Object[]> results = employeeRepository.findAllEmployeesWithRoleAndPosition();
            List<EmployeeDTO> employeeDTOs = results.stream().map(result -> {
                Employee employee = (Employee) result[0];
                String roleName = (String) result[1];
                String jobDescription = (String) result[2];

                EmployeeExtendedDTO dto = new EmployeeExtendedDTO();
                dto.setIdEmpleador(employee.getIdEmpleador());
                dto.setNombre(employee.getNombre());
                dto.setApellidos(employee.getApellidos());
                dto.setCorreoElectronico(employee.getCorreoElectronico());
                dto.setContrasena(employee.getContrasena());
                dto.setStatus(employee.getStatus());
                dto.setRoleName(roleName);
                dto.setJobDescription(jobDescription);

                return new EmployeeDTO(employee, dto);
            }).collect(Collectors.toList());
            
            return new ResponseEntity<>(
                Utils.respOk(employeeDTOs),
                HttpStatus.OK
            );
        }
        String paramDecode = Utils.getBase64(param);
        String[] parts = paramDecode.split(":");
        Employee emp1 = new Employee();
        List<Employee> res = null;
        res = switch (parts[0]) {
            case "idRol" -> this.employeeRepository.findEmployeeByidRol(Integer.parseInt(parts[1]));
            case "idCargo" -> this.employeeRepository.findEmployeeByidCargo(Integer.parseInt(parts[1]));
            default -> null;
        };
        return new ResponseEntity<>(
            Utils.respOk(res),
            HttpStatus.OK
        );
    };

    public ResponseEntity<Object> post(String data){
        Employee employee = Utils.getData(data, Employee.class);
        Optional<Employee> resCorreo = this.employeeRepository.findEmployeeBycorreoElectronico(employee.getCorreoElectronico());
        if(resCorreo.isPresent()){
            return new ResponseEntity<>(
               Utils.respError(null, LangCode.msg_existe_usuario ),
               HttpStatus.OK
            );
        }
        
        this.employeeRepository.save(employee);
        
        return new ResponseEntity<>(
               Utils.respMsg(LangCode.msg_create_employee ),
               HttpStatus.OK
        );
    }
    
    public ResponseEntity<Object> put(String data){
        Employee employee = Utils.getData(data, Employee.class);
        if(employee.getIdEmpleador() == null){
            return new ResponseEntity<>(
               Utils.respError(null, LangCode.msg_id_vacio ),
               HttpStatus.OK
            );
        }
        
        if(employee.getCorreoElectronico() != null){
            Optional<Employee> resCorreo = this.employeeRepository.findEmployeeBycorreoElectronico(employee.getCorreoElectronico());
            Employee employeeFound = resCorreo.get();
            if(resCorreo.isPresent() && (employeeFound.getIdEmpleador() != employee.getIdEmpleador())){
                return new ResponseEntity<>(
                   Utils.respError(null, LangCode.msg_existe_usuario ),
                   HttpStatus.OK
                );
            }
        }

        this.employeeRepository.save(employee);
        
        return new ResponseEntity<>(
               Utils.respMsg(LangCode.msg_update_employee ),
               HttpStatus.OK
        );
    }
    
    public ResponseEntity<Object> login(String data){
        Employee employee = Utils.getData(data, Employee.class);
        
        if(employee.getCorreoElectronico() == null || employee.getContrasena() == null){
            return new ResponseEntity<>(
               Utils.respError(null, LangCode.msg_parametros_vacios ),
               HttpStatus.OK
            );
        }
        
        Optional<Employee> resUser = this.employeeRepository.findEmployeeByCorreoElectronicoAndContrasenaAndStatus(employee.getCorreoElectronico(), employee.getContrasena(), 0);
        if(resUser.isPresent()){
            Employee user = resUser.get();
            List<Map<String, Object>> routes = null;
            routes = switch (user.getIdRol()) {
                case 1 -> Utils.rolesEmpleados();
                case 2 -> Utils.rolesEmpleadosJefe();
                default -> Utils.rolesEmpleados();
            };
      
            JSONObject responseUser = new JSONObject();
            responseUser.put("user", user);
            responseUser.put("routes", routes);
            return new ResponseEntity<>(
                Utils.respOk(responseUser),
                HttpStatus.OK
            );
        }
        
        return new ResponseEntity<>(
            Utils.respError(null, LangCode.msg_credenciales_invalidas ),
            HttpStatus.OK
        );
    }
}
