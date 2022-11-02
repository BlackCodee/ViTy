package com.misiontic.proyectovity.Services;

import com.misiontic.proyectovity.Models.Paciente;
import java.util.List;

public interface PacienteService {
    
    public Paciente save(Paciente paciente);
    public void delete(Integer id);
    public Paciente findById(Integer id);
    public List<Paciente> findAll();
    
}
