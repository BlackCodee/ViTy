
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
@Table(name="formulas")

public class Formulas implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idFormulas")
    private Integer idFormulas;   
    
    @ManyToOne
    @JoinColumn(name="idEspecialista")
    private Especialista idEspecialista;
    
    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario idUsuario;
    
    @ManyToOne
    @JoinColumn(name="idMedicamento")
    private Medicamento idMedicamento;
    
    @Column(name="cantidad")
    private Integer cantidad;
    
    @Column(name="estado")
    private String estado;

    /**
     * @return the idFormulas
     */
    public Integer getIdFormulas() {
        return idFormulas;
    }

    /**
     * @param idFormulas the idFormulas to set
     */
    public void setIdFormulas(Integer idFormulas) {
        this.idFormulas = idFormulas;
    }

    /**
     * @return the idEspecialista
     */
    public Especialista getIdEspecialista() {
        return idEspecialista;
    }

    /**
     * @param idEspecialista the idEspecialista to set
     */
    public void setIdEspecialista(Especialista idEspecialista) {
        this.idEspecialista = idEspecialista;
    }

    /**
     * @return the idUsuario
     */
    public Usuario getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the idMedicamento
     */
    public Medicamento getIdMedicamento() {
        return idMedicamento;
    }

    /**
     * @param idMedicamento the idMedicamento to set
     */
    public void setIdMedicamento(Medicamento idMedicamento) {
        this.idMedicamento = idMedicamento;
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
