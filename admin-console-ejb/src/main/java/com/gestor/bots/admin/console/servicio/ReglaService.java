/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.servicio;


import com.gestor.bots.admin.console.dao.ReglaDAO;
import com.gestor.bots.admin.console.enums.EstadoReglaEnum;
import com.gestor.bots.admin.console.model.Regla;
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
public class ReglaService {
    
    @EJB
    private ReglaDAO reglaDAO;
    
    public List<Regla> obtenerTodos() {
        return this.reglaDAO.findAll();
    }
    
    public void crear(Regla regla) throws CreacionException {
        try {
             regla.setEstado(EstadoReglaEnum.ACT);
            this.reglaDAO.insert(regla);
        } catch (Exception e) {
            throw new CreacionException("ERR100", "Error al crear: "+e.getMessage(), e);
        } 
    }
    
    public void modificar(Regla regla){
        try{
            this.reglaDAO.update(regla);
        }catch (Exception e){
            throw new ModificacionException("ERR200", e.getMessage(), e);
        }
    }
    
    public void eliminar(Regla regla){
        try{
            this.reglaDAO.remove(regla);
        }catch (Exception e){
            throw new EliminacionException("ERR300", e.getMessage(), e);
        }
    }
    
 
    
}
