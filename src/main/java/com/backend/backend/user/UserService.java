/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.user;

import com.backend.backend.employee.Employee;
import com.backend.backend.utils.Utils;
import com.backend.backend.utils.LangCode;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */

@Service
public class UserService {
    private final UserRepository userRepository;
    
    private PasswordEncoder passwordEncoder;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    
    public ResponseEntity<Object> get() {
        return new ResponseEntity<>(
            Utils.respOk(this.userRepository.findAll()),
            HttpStatus.OK
        );
    };
    
    public ResponseEntity<Object> post(String data){
        User user = Utils.getData(data, User.class);

        Optional<User> resCorreo = this.userRepository.findUserBycorreoElectronico(user.getCorreoElectronico());
        if(resCorreo.isPresent()){
            return new ResponseEntity<>(
               Utils.respError(null, LangCode.msg_existe_usuario ),
               HttpStatus.OK
            );
        }
        
        String enctyptPasssoword =  this.passwordEncoder.encode(user.getContrasena());
        user.setContrasena(enctyptPasssoword);
        user.setIdRol(1);
        this.userRepository.save(user);
        
        return new ResponseEntity<>(
               Utils.respMsg(LangCode.msg_create_user ),
               HttpStatus.OK
        );
    }
    
    public ResponseEntity<Object> login(String data){
        User user = Utils.getData(data, User.class);
        
        if(user.getCorreoElectronico() == null || user.getContrasena() == null){
            return new ResponseEntity<>(
               Utils.respError(null, LangCode.msg_parametros_vacios ),
               HttpStatus.OK
            );
        }

        Optional<User> resUser = this.userRepository.findEmployeeByCorreoElectronicoAndStatus(user.getCorreoElectronico(), 0);
        if(resUser.isPresent()){
            User userResponse = resUser.get();
            boolean isPwdRight = this.passwordEncoder.matches(user.getContrasena(), userResponse.getContrasena());
            if(isPwdRight){
                 List<Map<String, Object>> routes = null;
                routes = switch (userResponse.getIdRol()) {
                    case 1 -> Utils.rolesEmpleadosUsuario();
                    case 2 -> Utils.rolesEmpleadosJefe();
                    case 3 -> Utils.rolesEmpleados();
                    default -> Utils.rolesEmpleadosUsuario();
                };

                JSONObject responseUser = new JSONObject();
                responseUser.put("user", userResponse);
                responseUser.put("routes", routes);
                return new ResponseEntity<>(
                    Utils.respOk(responseUser),
                    HttpStatus.OK
                );
            }else{
                return new ResponseEntity<>(
                  Utils.respError(null, LangCode.msg_credenciales_invalidas ),
                  HttpStatus.OK
                );  
            }
           
        }
        
        return new ResponseEntity<>(
            Utils.respError(null, LangCode.msg_credenciales_invalidas ),
            HttpStatus.OK
        );
    }
    
    public ResponseEntity<Object> put(String data){
        User user = Utils.getData(data, User.class);
        
        if(user.getIdUsuario() == null){
            return new ResponseEntity<>(
               Utils.respError(null, LangCode.msg_id_vacio ),
               HttpStatus.OK
            );
        }
        
        this.userRepository.save(user);
        
        return new ResponseEntity<>(
               Utils.respMsg(LangCode.msg_update_user ),
               HttpStatus.OK
        );
    }
}
