package com.misiontic.proyectovity.Services.Implement;

import com.misiontic.proyectovity.Services.UsuarioService;
import com.misiontic.proyectovity.Dao.UsuarioDao;
import com.misiontic.proyectovity.Models.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    @Transactional(readOnly=false)
    public Usuario save(Usuario usuario){
        return usuarioDao.save(usuario);
    }
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id){
        usuarioDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly=true)
    public Usuario findById(Integer id){
        return usuarioDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Usuario> findAll(){
        return (List<Usuario>) usuarioDao.findAll();
    }
}
