package com.misiontic.proyectovity.Services;

import com.misiontic.proyectovity.Models.Formulas;
import java.util.List;

public interface FormulasService {

    public Formulas save(Formulas formulas);
    public void delete(Integer id);
    public Formulas findById(Integer id);
    public List<Formulas> findAll();
    
}
