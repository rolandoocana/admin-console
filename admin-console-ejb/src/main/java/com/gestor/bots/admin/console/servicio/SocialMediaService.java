/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.servicio;

import com.gestor.bots.admin.console.dao.SocialMediaDAO;
import com.gestor.bots.admin.console.model.SocialMedia;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Hendrix
 */
@LocalBean
@Stateless
public class SocialMediaService {
    
    @EJB
    private SocialMediaDAO socialMediaDAO;
    
    public List<SocialMedia> obtenerTodos() {
        return this.socialMediaDAO.findAll();
    }
    
    public void crear(SocialMedia socialMedia)  {
        try {
            this.socialMediaDAO.insert(socialMedia);
        } catch (Exception e) {
            throw new CreacionException("ERR001", e.getMessage() ,e);
        }
    }
    
    
}
