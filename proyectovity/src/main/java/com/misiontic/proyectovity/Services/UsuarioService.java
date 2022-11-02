package com.misiontic.proyectovity.Services;

import com.misiontic.proyectovity.Models.Usuario;
import java.util.List;

public interface UsuarioService {
    
    public Usuario save(Usuario usuario);
    public void delete(Integer id);
    public Usuario findById(Integer id);
    public List<Usuario> findAll();
    
}
