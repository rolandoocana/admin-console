/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.dao;

import com.persist.common.dao.DefaultGenericDAOImple;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
/**
 *
 * @author Gestor_1
 */
@LocalBean
@Stateless
public class RegistroLoginDAO extends DefaultGenericDAOImple<RegistroLogin, Integer> {
    public RegistroLoginDAO(){
        super(RegistroLogin.class);
    }
}