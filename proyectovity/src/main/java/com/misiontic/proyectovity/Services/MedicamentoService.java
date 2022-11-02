package com.misiontic.proyectovity.Services;

import com.misiontic.proyectovity.Models.Medicamento;
import java.util.List;

public interface MedicamentoService {
    
    public Medicamento save(Medicamento medicamento);
    public void delete(Integer id);
    public Medicamento findById(Integer id);
    public List<Medicamento> findAll();
    
}
