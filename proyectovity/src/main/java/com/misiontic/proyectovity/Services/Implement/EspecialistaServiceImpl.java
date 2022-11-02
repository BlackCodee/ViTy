package com.misiontic.proyectovity.Services.Implement;

import com.misiontic.proyectovity.Services.EspecialistaService;
import com.misiontic.proyectovity.Dao.EspecialistaDao;
import com.misiontic.proyectovity.Models.Especialista;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class EspecialistaServiceImpl implements EspecialistaService{
    @Autowired
    private EspecialistaDao especialistaDao;
    
    @Override
    @Transactional(readOnly=false)
    public Especialista save(Especialista especialista){
        return especialistaDao.save(especialista);
    }
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id){
        especialistaDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly=true)
    public Especialista findById(Integer id){
        return especialistaDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Especialista> findAll(){
        return (List<Especialista>) especialistaDao.findAll();
    }
}
