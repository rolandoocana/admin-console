/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.web;

import com.gestor.bots.admin.console.model.Bot;
import com.gestor.bots.admin.console.model.Cliente;
import com.gestor.bots.admin.console.servicio.BotService;
import com.gestor.bots.admin.console.web.common.BaseBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Hendrix
 */
@Named
@ViewScoped
public class BotBean extends BaseBean implements Serializable{
    
    @Inject
    private BotService botService;
    
    private List<Cliente> clientesConBot;
    
    private List<Bot> bots;
    
    @PostConstruct
    private void init() {
        this.clientesConBot = this.botService.obtenerClientesConBots();
    }
    
    public void seleccionar() {
        this.bots = this.botService.obtenerPorRuc(super.getFiltro());
    }

    public List<Cliente> getClientesConBot() {
        return clientesConBot;
    }
    
    
    
    
}
