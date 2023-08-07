/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.backend.position;

import com.backend.backend.status.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Administrador
 */
public class PositionDTO {
    private Position data;
    private PositionExtendedDTO parseData;

    public PositionDTO(Position data, PositionExtendedDTO parseData) {
        this.data = data;
        this.parseData = parseData;
    }

    public void setPosition(Position position) {
        this.data = position;
    }

    public void setPositionExtendedDTO(PositionExtendedDTO positionExtendedDTO) {
        this.parseData = positionExtendedDTO;
    }

    @JsonProperty("data")
    public Position getPosition() {
        return data;
    }

    @JsonProperty("parseData")
    public PositionExtendedDTO getPositionExtendedDTO() {
        return parseData;
    }
}
