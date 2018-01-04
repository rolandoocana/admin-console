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
public class CreacionException extends RuntimeException{

    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public CreacionException(String codigo) {
        this.codigo = codigo;
    }

    public CreacionException(String codigo, String message) {
        super(message);
        this.codigo = codigo;
    }

    public CreacionException(String codigo, String message, Throwable cause) {
        super(message, cause);
        this.codigo = codigo;
    }


    
    
}
