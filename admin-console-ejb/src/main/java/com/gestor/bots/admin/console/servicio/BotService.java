/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.servicio;

import com.gestor.bots.admin.console.dao.BotDAO;
import com.gestor.bots.admin.console.dao.ClienteDAO;
import com.gestor.bots.admin.console.model.Bot;
import com.gestor.bots.admin.console.model.Cliente;
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
public class BotService {
    
    @EJB
    private ClienteDAO clienteDAO;
    @EJB
    private BotDAO botDAO;
    
    public List<Cliente> obtenerClientesConBots() {
        return this.clienteDAO.findWithBot();
    }
    
    public List<Bot> obtenerPorRuc(String ruc) {
        return this.botDAO.findByRuc(ruc);
    }
}
