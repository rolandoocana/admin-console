/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.servicio;


import com.gestor.bots.admin.console.dao.SinonimoDAO;
import com.gestor.bots.admin.console.model.Sinonimo;
import com.gestor.bots.exception.CreacionException;
import com.gestor.bots.exception.EliminacionException;
import com.gestor.bots.exception.ModificacionException;
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
public class SinonimoService {
    
    @EJB
    private SinonimoDAO sinonimoDAO;
    
    public List<Sinonimo> obtenerTodos() {
        return this.sinonimoDAO.findAll();
    }
    
    public void crear(Sinonimo sinonimo) throws CreacionException {
        try {
            this.sinonimoDAO.insert(sinonimo);
        } catch (Exception e) {
            throw new CreacionException("ERR100", "Error al crear: "+e.getMessage(), e);
        } 
    }
    
    public void modificar(Sinonimo sinonimo){
        try{
            this.sinonimoDAO.update(sinonimo);
        }catch (Exception e){
            throw new ModificacionException("ERR200", e.getMessage(), e);
        }
    }
    
    public void eliminar(Sinonimo sinonimo){
        try{
            this.sinonimoDAO.remove(sinonimo);
        }catch (Exception e){
            throw new EliminacionException("ERR300", e.getMessage(), e);
        }
    }
    
 
    
}
