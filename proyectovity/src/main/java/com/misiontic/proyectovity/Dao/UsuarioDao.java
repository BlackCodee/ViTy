package com.misiontic.proyectovity.Dao;

import com.misiontic.proyectovity.Models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario,Integer>{
    
}
