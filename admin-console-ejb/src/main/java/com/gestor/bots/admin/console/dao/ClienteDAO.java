/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.dao;

import com.gestor.bots.admin.console.model.Cliente;
import com.persist.common.dao.DefaultGenericDAOImple;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Hendrix
 */
@LocalBean
@Stateless
public class ClienteDAO extends DefaultGenericDAOImple<Cliente, String> {
    
    public ClienteDAO() {
        super(Cliente.class);
    }
    
    public List<Cliente> findWithBot() {
        Query qry = super.getEntityManager().createQuery("SELECT obj FROM Cliente obj WHERE obj.ruc in (SELECT DISTINCT (b.ruc) FROM Bot b)");
        return qry.getResultList();
    }
}
