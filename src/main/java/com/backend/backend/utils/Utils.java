/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.micrometer.common.lang.Nullable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.misc.NotNull;
import org.json.simple.JSONObject;
/**
 *
 * @author Administrador
 */
public class Utils {
    
    public Utils(){}
    
    public static Gson gson = new Gson();
    
    public static <T> T getData(@Nullable String data, @NotNull Class<T> clase) {
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(data);
        if (!jsonElement.isJsonObject()) {
            return null;
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonElement dataJson = jsonObject.get("data");
        if (dataJson == null || !dataJson.isJsonObject()) {
            return null;
        }
        return gson.fromJson(dataJson, clase);
    }
    
    public static JSONObject respOk(@NotNull Object data) {
        JSONObject res = new JSONObject();
        res.put("isError", false);
        res.put("response", data);
        try {
            res.put("server", InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException ex) {
            
        }
        return res;
    }
    
    public static JSONObject respError(@Nullable Throwable e, @Nullable LangCode msg) {
        if (msg == null) {
            msg = LangCode.error_server;
        }
        JSONObject res = new JSONObject();
        res.put("isError", true);
        res.put("response", Const.getError(msg));
        try {
            
            res.put("server", InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException ex) {
            
        }
        if (e != null) {
             String errTxt = "";
            if(e.getMessage() != null){
                errTxt = new Gson().toJson(e);
                //res.addProperty("error", );
            }else{
                errTxt = "Error indefinido: "+e;
            }
             errTxt += " Detail:"+e.getLocalizedMessage();
            res.put("error", e.getMessage() + " || "+e.getCause()+" || "+errTxt);
        }
        return res;
    }
    
    public static JSONObject respMsg(@Nullable LangCode msg) {
        JSONObject res = new JSONObject();
        res.put("isError", false);
        res.put("response", Const.getError(msg));
         try {
            res.put("server", InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException ex) {
            
        }
        return res;
    }
    
    public static String getBase64(String encodedString){
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);

        String decodedString = new String(decodedBytes);
        
        return decodedString;
    }
    
    public static List<Map<String, Object>> rolesEmpleados() {
        List<Map<String, Object>> listaRolesEmpleado = new ArrayList<>();
        
        List<Map<String, Object>> roles = new ArrayList<>();

        Map<String, Object> role1 = new HashMap<>();
        role1.put("modulo", "solicitudes");
        role1.put("roles", List.of("crear"));
        roles.add(role1);

        Map<String, Object> role = new HashMap<>();
        role.put("path", "solicitudes");
        role.put("title", "Solicitudes");
        role.put("icon", "bi bi-bell");
        role.put("name", "solicitudes");
        role.put("permisos", roles);
        
        listaRolesEmpleado.add(role);
        
        return listaRolesEmpleado;
    };
    
    public static List<Map<String, Object>> rolesEmpleadosJefe() {
        List<Map<String, Object>> listaRolesEmpleado = new ArrayList<>();
        
        List<Map<String, Object>> roles = new ArrayList<>();

        Map<String, Object> role1 = new HashMap<>();
        role1.put("modulo", "solicitudes");
        role1.put("roles", List.of("editar"));
        roles.add(role1);

        Map<String, Object> role2 = new HashMap<>();
        role2.put("modulo", "misSolicitudes");
        role2.put("roles", List.of("crear"));
        roles.add(role2);
        
        Map<String, Object> role = new HashMap<>();
        role.put("path", "solicitudes");
        role.put("title", "Solicitudes");
        role.put("icon", "bi bi-card-checklist");
        role.put("name", "solicitudes");
        role.put("permisos", roles);
        
        listaRolesEmpleado.add(role);
        
        return listaRolesEmpleado;
    };
    
    public static List<Map<String, Object>> rolesEmpleadosUsuario() {
        List<Map<String, Object>> roles = new ArrayList<>();

        // Create permission maps for each role
        List<Map<String, Object>> usuariosPermisos = createPermissions("usuarios", "crear", "editar");
        List<Map<String, Object>> areasPermisos = createPermissions("areas", "crear", "editar");
        List<Map<String, Object>> cargosPermisos = createPermissions("cargos", "crear", "editar");
        List<Map<String, Object>> estadosPermisos = createPermissions("estados", "crear", "editar");
        List<Map<String, Object>> tipoSolicitudesPermisos = createPermissions("tipo-solicitudes", "crear", "editar");
        List<Map<String, Object>> empleadosPermisos = createPermissions("empleados", "crear", "editar");
        List<Map<String, Object>> solicitudesPermisos = createPermissions("solicitudes", "crear", "editar");
        List<Map<String, Object>> rolesPermisos = createPermissions("roles", "crear", "editar");
        
        // Create roles with permissions
        roles.add(createRoleWithPermissions("usuarios", "Usuarios", "bi bi-people-fill", "usuarios", usuariosPermisos));
        roles.add(createRoleWithPermissions("areas", "Areas", "bi bi-textarea", "areas", areasPermisos));
        roles.add(createRoleWithPermissions("cargos", "Cargo", "bi bi-person-bounding-box", "cargos", cargosPermisos));
        roles.add(createRoleWithPermissions("estados", "Estados", "bi bi-calendar3", "estados", estadosPermisos));
        roles.add(createRoleWithPermissions("tipo-solicitudes", "Tipo Solicitudes", "bi bi-hand-index-thumb-fill", "tipo-solicitudes", tipoSolicitudesPermisos));
        roles.add(createRoleWithPermissions("empleados", "Empleados", "bi bi-person", "empleados", empleadosPermisos));
        roles.add(createRoleWithPermissions("solicitudes", "Solicitudes", "bi bi-card-checklist", "solicitudes", solicitudesPermisos));
        roles.add(createRoleWithPermissions("roles", "Roles", "bi bi-person-fill-gear", "roles", rolesPermisos));
        
        return roles;
    };
    
    public static Map<String, Object> createRole(String path, String title, String icon, String name, List<Object> permisos) {
        Map<String, Object> role = new HashMap<>();
        role.put("path", path);
        role.put("title", title);
        role.put("icon", icon);
        role.put("name", name);
        role.put("permisos", permisos);
        return role;
    }

    public static Map<String, Object> createRoleWithPermissions(String path, String title, String icon, String name, List<Map<String, Object>> permisos) {
        Map<String, Object> role = createRole(path, title, icon, name, new ArrayList<>());
        role.put("permisos", permisos);
        return role;
    }

    public static List<Map<String, Object>> createPermissions(String modulo, String... roles) {
        List<Map<String, Object>> permissionsList = new ArrayList<>();
        Map<String, Object> permissions = new HashMap<>();
        permissions.put("modulo", modulo);
        permissions.put("roles", List.of(roles));
        permissionsList.add(permissions);
        return permissionsList;
    } 
}
