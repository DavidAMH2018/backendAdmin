/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Administrador
 */
public class RequestDTO {
    private Request data;
    private RequestExtendedDTO parseData;

    public RequestDTO(Request data, RequestExtendedDTO parseData) {
        this.data = data;
        this.parseData = parseData;
    }

    public void setRequest(Request employee) {
        this.data = employee;
    }

    public void setRequestExtendedDTO(RequestExtendedDTO employeeExtendedDTO) {
        this.parseData = employeeExtendedDTO;
    }

    @JsonProperty("data")
    public Request getRequest() {
        return data;
    }

    @JsonProperty("parseData")
    public RequestExtendedDTO getRequestExtendedDTO() {
        return parseData;
    }
}
