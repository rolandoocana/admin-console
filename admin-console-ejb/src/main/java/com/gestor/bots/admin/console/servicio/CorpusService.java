/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.servicio;



import com.gestor.bots.admin.console.dao.CorpusDAO;
import com.gestor.bots.admin.console.model.Corpus;
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
public class CorpusService {
    
    @EJB
    private CorpusDAO corpusDAO;
    
    public List<Corpus> obtenerTodos() {
        return this.corpusDAO.findAll();
    }
    
    public void crear(Corpus corpus) throws CreacionException {
        try {
            this.corpusDAO.insert(corpus);
        } catch (Exception e) {
            throw new CreacionException("ERR100", "Error al crear: "+e.getMessage(), e);
        } 
    }
    
    public void modificar(Corpus corpus){
        try{
            this.corpusDAO.update(corpus);
        }catch (Exception e){
            throw new ModificacionException("ERR200", e.getMessage(), e);
        }
    }
    
    public void eliminar(Corpus corpus){
        try{
            this.corpusDAO.remove(corpus);
        }catch (Exception e){
            throw new EliminacionException("ERR300", e.getMessage(), e);
        }
    }
    
 
    
}
