package com.misiontic.proyectovity.Services.Implement;

import com.misiontic.proyectovity.Services.RolService;
import com.misiontic.proyectovity.Dao.RolDao;
import com.misiontic.proyectovity.Models.Rol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class RolServiceImpl implements RolService{
    @Autowired
    private RolDao rolDao;
    
    @Override
    @Transactional(readOnly=false)
    public Rol save(Rol rol){
        return rolDao.save(rol);
    }
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id){
        rolDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly=true)
    public Rol findById(Integer id){
        return rolDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Rol> findAll(){
        return (List<Rol>) rolDao.findAll();
    }
}
