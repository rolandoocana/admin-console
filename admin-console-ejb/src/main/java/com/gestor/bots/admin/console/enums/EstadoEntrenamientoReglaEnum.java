/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.enums;

/**
 *
 * @author Gestor
 */
public enum EstadoEntrenamientoReglaEnum {
      /** Definido */
    DEF("Definido"),
    /** Activo */
    ACT("Activo"),
    /** Inactivo */
    INA("Inactivo");
    
    private final String etiqueta;
    
    private EstadoEntrenamientoReglaEnum(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
}
