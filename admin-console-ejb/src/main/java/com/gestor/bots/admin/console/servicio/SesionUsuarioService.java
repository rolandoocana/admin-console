/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.servicio;

import com.gestor.bots.admin.console.dao.RegistroLoginDAO;
import com.gestor.bots.admin.console.dao.UsuarioDAO;
import com.gestor.bots.admin.console.model.RegistroLogin;
import com.gestor.bots.admin.console.model.Usuario;
import java.util.Date;
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
    @EJB
    private RegistroLoginDAO registroLoginDAO;
    
    
    public Usuario autenticar(String username, String password, String ip) {
        RegistroLogin registroLogin = new RegistroLogin();
        registroLogin.setFecha(new Date());
        registroLogin.setIp(ip);
        registroLogin.setUsername(username);
        registroLogin.setResultado("BAD");
        Usuario user = this.usuarioDAO.findById(username, false);
        if (user!=null) {
            String passwordEnc = DigestUtils.sha256Hex(password);
            if (user.getClave().equals(passwordEnc)) {
                registroLogin.setResultado("OK");
            }
        }
        this.registroLoginDAO.insert(registroLogin);
        return user;
    }  
    
}
