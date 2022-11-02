package com.misiontic.proyectovity.Services;

import com.misiontic.proyectovity.Models.Rol;
import java.util.List;

public interface RolService {
    
    public Rol save(Rol rol);
    public void delete(Integer id);
    public Rol findById(Integer id);
    public List<Rol> findAll();
}
