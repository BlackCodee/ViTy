package com.misiontic.proyectovity.Services;

import com.misiontic.proyectovity.Models.Citas;
import java.util.List;

public interface CitasService {

    public Citas save(Citas citas);
    public void delete(Integer id);
    public Citas findById(Integer id);
    public List<Citas> findAll();
    
}
