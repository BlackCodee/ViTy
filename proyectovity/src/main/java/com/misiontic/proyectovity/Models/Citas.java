
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
import java.sql.Date;

@Entity
@Table(name="citas")

public class Citas implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name="idc")
    private Integer idc;   
    
    @Column(name="fecha")
    private String fecha;
    
    @Column(name="nombrePaciente")
    private String nombrePaciente;
    
    @Column(name="nombreEspecialista")
    private String nombreEspecialista;
    
    @Column(name="detalle")
    private String detalle;

    /**
     * @return the idc
     */
    public Integer getIdc() {
        return idc;
    }

    /**
     * @param idc the idc to set
     */
    public void setIdc(Integer idc) {
        this.idc = idc;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the nombrePaciente
     */
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    /**
     * @param nombrePaciente the nombrePaciente to set
     */
    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
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
     * @return the detalle
     */
    public String getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
}
