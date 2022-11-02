
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
@Table(name="descita")

public class Descita implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name="id_descita")
    private Integer id_descita;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="estado")
    private String estado;

    /**
     * @return the id_descita
     */
    public Integer getId_descita() {
        return id_descita;
    }

    /**
     * @param id_descita the id_descita to set
     */
    public void setId_descita(Integer id_descita) {
        this.id_descita = id_descita;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
