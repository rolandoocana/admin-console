/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.servicio;



import com.gestor.bots.admin.console.dao.EntrenamientoReglaDAO;
import com.gestor.bots.admin.console.enums.EstadoEntrenamientoReglaEnum;
import com.gestor.bots.admin.console.model.EntrenamientoRegla;
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
public class EntrenamientoReglaService {
    
    @EJB
    private EntrenamientoReglaDAO entrenamientoReglaDAO;
    
    public List<EntrenamientoRegla> obtenerTodos() {
        return this.entrenamientoReglaDAO.findAll();
    }
    
    public void crear(EntrenamientoRegla entrenamientoRegla) throws CreacionException {
        try {
             entrenamientoRegla.setEstado("ACT");
            this.entrenamientoReglaDAO.insert(entrenamientoRegla);
        } catch (Exception e) {
            throw new CreacionException("ERR100", "Error al crear: "+e.getMessage(), e);
        } 
    }
    
    public void modificar(EntrenamientoRegla entrenamientoRegla){
        try{
            this.entrenamientoReglaDAO.update(entrenamientoRegla);
        }catch (Exception e){
            throw new ModificacionException("ERR200", e.getMessage(), e);
        }
    }
    
    public void eliminar(EntrenamientoRegla entrenamientoRegla){
        try{
            this.entrenamientoReglaDAO.remove(entrenamientoRegla);
        }catch (Exception e){
            throw new EliminacionException("ERR300", e.getMessage(), e);
        }
    }
    
 
    
}
