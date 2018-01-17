/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.servicio;

import com.gestor.bots.admin.console.dao.UsuarioDAO;
import com.gestor.bots.admin.console.enums.EstadoUsuarioEnum;
import com.gestor.bots.admin.console.model.Usuario;
import com.gestor.bots.exception.CreacionException;
import com.gestor.bots.exception.EliminacionException;
import com.gestor.bots.exception.ModificacionException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Gestor_1
 */
@LocalBean
@Stateless
public class UsuarioService {

    @EJB
    private UsuarioDAO usuarioDAO;

    public List<Usuario> obtenerTodos() {
        return this.usuarioDAO.findAll();
    }
    
    public List<Usuario> buscar(String tipoFiltro, String valor) {
        System.err.println("El valor es: "+valor+", el tipo es:"+tipoFiltro);
        Usuario usuario = new Usuario();
        if ("NOM".equals(tipoFiltro)) {
            usuario.setNombre(valor);
        } else if ("EST".equals(tipoFiltro)) {
            usuario.setEstado(EstadoUsuarioEnum.valueOf(valor));
            System.err.println("El estado del usuario es:"+usuario.getEstado());
        } 
        return this.usuarioDAO.find(usuario);
    }
    
    public void crear(Usuario usuario)  {
        try {
            usuario.setFechaCreacion(new Date());
            usuario.setEstado(EstadoUsuarioEnum.ACT);
            String claveEnc = DigestUtils.sha256Hex(usuario.getClave());
            usuario.setClave(claveEnc);
            this.usuarioDAO.insert(usuario);
        } catch (Exception e) {
            throw new CreacionException("ERR100", e.getMessage() ,e);
        }
    }
    
    public void modificar(Usuario usuario)  {
        try {
            this.usuarioDAO.update(usuario);
        } catch (Exception e) {
            throw new ModificacionException("ERR200", e.getMessage() ,e);
        }
    }
    
    public void eliminar(Usuario usuario)  {
        try {
            this.usuarioDAO.remove(usuario);
        } catch (Exception e) {
            throw new EliminacionException("ERR300", e.getMessage() ,e);
        }
    }

}
