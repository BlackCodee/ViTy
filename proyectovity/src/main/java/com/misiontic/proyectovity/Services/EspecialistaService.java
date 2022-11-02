package com.misiontic.proyectovity.Services;

import com.misiontic.proyectovity.Models.Especialista;
import java.util.List;

public interface EspecialistaService {
 
    public Especialista save(Especialista especialista);
    public void delete(Integer id);
    public Especialista findById(Integer id);
    public List<Especialista> findAll();

}
