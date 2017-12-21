/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.bots.admin.console.model;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hendrix
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente {
    
    @Id
    @Column(name = "RUC", length =13 )
    private String ruc;
    
    @Column(name = "RAZON_SOCIAL", length = 100)
    private String razonSocial;
    
    @Column(name = "NOMBRE_COMERCIAL", length = 100)
    private String nombreComercial;
    
    @Column(name = "DIRECCION", length = 200)
    private String direccion;
    
    @Column(name = "PERSONA_CONTACTO", length = 100)
    private String personaContacto;
    
    @Column(name = "MAIL_CONTACTO", length = 100)
    private String mailContacto;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_REGISTRO")
    private Date fechaRegistro;
    
    public Cliente() {
        
    }

    public Cliente(String ruc) {
        this.ruc = ruc;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPersonaContacto() {
        return personaContacto;
    }

    public void setPersonaContacto(String personaContacto) {
        this.personaContacto = personaContacto;
    }

    public String getMailContacto() {
        return mailContacto;
    }

    public void setMailContacto(String mailContacto) {
        this.mailContacto = mailContacto;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.ruc);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.ruc, other.ruc)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "ruc=" + ruc + ", razonSocial=" + razonSocial + '}';
    }
    
    
}
