/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.exception;

/**
 *
 * @author David
 */
public class ModificacionException extends RuntimeException {
    
        private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public ModificacionException(String codigo) {
        this.codigo = codigo;
    }

    public ModificacionException(String codigo, String message) {
        super(message);
        this.codigo = codigo;
    }

    public ModificacionException(String codigo, String message, Throwable cause) {
        super(message, cause);
        this.codigo = codigo;
    }
    
    
}
