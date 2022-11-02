
package com.misiontic.proyectovity.Models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="medicamento")

public class Medicamento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name="idMedicamento")
    private Integer idMedicamento;
    
    @Column(name="nombreMedicamento")
    private String nombreMedicamento;
    
    @Column(name="nombreCientifico")
    private String nombreCientifico;
    
    @Column(name="concentracion")
    private String concentracion;
    
    @Column(name="cantidad")
    private Integer cantidad;
    
    @Column(name="estado")
    private String estado;

    /**
     * @return the idMedicamento
     */
    public Integer getIdMedicamento() {
        return idMedicamento;
    }

    /**
     * @param idMedicamento the idMedicamento to set
     */
    public void setIdMedicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    /**
     * @return the nombreMedicamento
     */
    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    /**
     * @param nombreMedicamento the nombreMedicamento to set
     */
    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    /**
     * @return the nombreCientifico
     */
    public String getNombreCientifico() {
        return nombreCientifico;
    }

    /**
     * @param nombreCientifico the nombreCientifico to set
     */
    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    /**
     * @return the concentracion
     */
    public String getConcentracion() {
        return concentracion;
    }

    /**
     * @param concentracion the concentracion to set
     */
    public void setConcentracion(String concentracion) {
        this.concentracion = concentracion;
    }

    /**
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
