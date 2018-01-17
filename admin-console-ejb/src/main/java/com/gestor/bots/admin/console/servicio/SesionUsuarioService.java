/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.servicio;

import com.gestor.bots.admin.console.dao.UsuarioDAO;
import com.gestor.bots.admin.console.model.Usuario;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Hendrix
 */
@Stateless
@LocalBean
public class SesionUsuarioService {
    
    @EJB
    private UsuarioDAO usuarioDAO;
    
    
    public Usuario autenticar(String username, String password) {
        Usuario user = this.usuarioDAO.findById(username, false);
        if (user!=null) {
            String passwordEnc = DigestUtils.sha256Hex(password);
            if (user.getClave().equals(passwordEnc)) {
                return user;
            }
        }
        return null;
    }
    
}
