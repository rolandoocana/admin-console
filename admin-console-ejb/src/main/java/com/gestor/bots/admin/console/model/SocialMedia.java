package com.gestor.bots.admin.console.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Hendrix
 */
@Entity
@Table(name = "SOCIAL_MEDIA")
public class SocialMedia {
    
    @Id
    @Column(name = "COD_SOCIAL_MEDIA", length = 15, nullable = false)
    private String codigo;
    
    @Column(name = "NOMBRE", length = 100, nullable = false)
    private String nombre;
    
}
