
package com.misiontic.proyectovity.Models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="especialista")

public class Especialista implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name="ide")
    private Integer ide;   
       
    @Column(name="documento")
    private String documento;
    
    @Column(name="nombreEspecialista")
    private String nombreEspecialista;
    
    @Column(name="telefono")
    private String telefono;
    
    @Column(name="correo")
    private String correo;

    /**
     * @return the ide
     */
    public Integer getIde() {
        return ide;
    }

    /**
     * @param ide the ide to set
     */
    public void setIde(Integer ide) {
        this.ide = ide;
    }

    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * @return the nombreEspecialista
     */
    public String getNombreEspecialista() {
        return nombreEspecialista;
    }

    /**
     * @param nombreEspecialista the nombreEspecialista to set
     */
    public void setNombreEspecialista(String nombreEspecialista) {
        this.nombreEspecialista = nombreEspecialista;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
        
}
