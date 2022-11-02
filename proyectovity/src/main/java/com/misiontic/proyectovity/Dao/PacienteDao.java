package com.misiontic.proyectovity.Dao;

import com.misiontic.proyectovity.Models.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface PacienteDao extends CrudRepository<Paciente,Integer>{
    
}
