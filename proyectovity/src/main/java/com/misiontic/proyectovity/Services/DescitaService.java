package com.misiontic.proyectovity.Services;

import com.misiontic.proyectovity.Models.Descita;
import java.util.List;

public interface DescitaService {
    
    public Descita save(Descita descita);
    public void delete(Integer id);
    public Descita findById(Integer id);
    public List<Descita> findAll();
}
