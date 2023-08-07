/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.utils;

import java.util.HashMap;

/**
 *
 * @author Administrador
 */
public class Const {
    
    public static HashMap<LangCode, String> langCode;
    
    public static final String VERSION = "v1";
    
    public static String getError(LangCode key) {
        if (langCode == null) {
            initErrorList();
        }

        try {
            return langCode.get(key);
        } catch (Exception e) {
            return "Error indefinido";
        }
    }
    
    private static void initErrorList() {
        langCode = new HashMap<LangCode, String>(35, 0.75f);
        //errores
        langCode.put(LangCode.error_server, "Por el momento este servicio no se encuentra disponible.");

        //mensajes   
        langCode.put(LangCode.msg_create_employee, "Empleado creado con exito.");
        langCode.put(LangCode.msg_update_employee, "Empleado actualizado con exito.");
        langCode.put(LangCode.msg_existe_usuario, "Ya existe este usuario.");
        langCode.put(LangCode.msg_id_vacio, "Id del empleado vacio!.");  
        langCode.put(LangCode.msg_create_position, "Cargo creado con exito."); 
        langCode.put(LangCode.msg_update_position, "Cargo actualizado con exito.");     
        langCode.put(LangCode.msg_create_area, "Area creada con exito."); 
        langCode.put(LangCode.msg_update_area, "Area actualizada con exito."); 
        langCode.put(LangCode.msg_create_request, "Solicitud creada con exito."); 
        langCode.put(LangCode.msg_update_request, "Solicitud actualizada con exito."); 
        langCode.put(LangCode.msg_create_typerequest, "Tipo Solicitud creada con exito."); 
        langCode.put(LangCode.msg_update_typerequest, "Tipo Solicitud actualizada con exito."); 
        langCode.put(LangCode.msg_create_status, "Estado creado con exito."); 
        langCode.put(LangCode.msg_update_status, "Estado actualizado con exito.");
        langCode.put(LangCode.msg_create_user, "Usuario creado con exito."); 
        langCode.put(LangCode.msg_update_user, "Usuario actualizado con exito."); 
        langCode.put(LangCode.msg_create_rol, "Rol creado con exito."); 
        langCode.put(LangCode.msg_update_rol, "Rol actualizado con exito."); 
        langCode.put(LangCode.msg_parametros_vacios, "Parametros vacios"); 
        langCode.put(LangCode.msg_credenciales_invalidas, "No se encontro usuarios con las credenciales enviadas o el usuario esta inactivo."); 
        
    }
}
