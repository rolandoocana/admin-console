/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.web;

import com.gestor.bots.admin.console.model.Usuario;
import com.gestor.bots.admin.console.servicio.SesionUsuarioService;
import com.gestor.bots.admin.console.web.common.FacesUtil;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Hendrix
 */
@Named
@ViewScoped
public class LoginBean implements Serializable{
    
    private String username;
    private String password;
    
    @Inject
    private SesionUsuarioService sesionUsuarioService;
    
    public String autenticar() {
        Usuario usuario = this.sesionUsuarioService.autenticar(this.username, this.password);
        if (usuario!=null) {
            return "menu";
        } else {
            FacesUtil.addMessageError(null, "El usuario y/o clave no corresponden");
            return "index";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
