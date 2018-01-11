/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.web.common;

import java.io.Serializable;

/**
 *
 * @author Hendrix
 */
public class BaseBean<T>implements Serializable {

    private boolean enNuevo;
    private boolean enModificar;
    private boolean enConsulta;
    
    protected String tituloPanel;

    
    public void nuevo() {
        this.enNuevo = true;
        this.tituloPanel = "Registro de ";
    }
    
    public void modificar() {
        this.enModificar = true;
        this.tituloPanel = "Modificacion de ";
    }
    
    public void consultar() {
        this.enConsulta = true;
        this.tituloPanel = "Consulta Datos de ";
    }
    
    public void cancelar() {
        this.enNuevo = false;
        this.enModificar = false;
        this.enConsulta = false;
    }

    public boolean isEnNuevo() {
        return enNuevo;
    }

    public boolean isEnModificar() {
        return enModificar;
    }

    public boolean isEnConsulta() {
        return enConsulta;
    }


    
    
}
