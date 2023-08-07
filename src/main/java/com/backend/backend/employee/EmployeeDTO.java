/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.employee;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Administrador
 */

public class EmployeeDTO {
    private Employee data;
    private EmployeeExtendedDTO parseData;

    public EmployeeDTO(Employee data, EmployeeExtendedDTO parseData) {
        this.data = data;
        this.parseData = parseData;
    }

    public void setEmployee(Employee employee) {
        this.data = employee;
    }

    public void setEmployeeExtendedDTO(EmployeeExtendedDTO employeeExtendedDTO) {
        this.parseData = employeeExtendedDTO;
    }

    @JsonProperty("data")
    public Employee getEmployee() {
        return data;
    }

    @JsonProperty("parseData")
    public EmployeeExtendedDTO getEmployeeExtendedDTO() {
        return parseData;
    }
}
