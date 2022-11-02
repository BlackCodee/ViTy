package com.misiontic.proyectovity.Services.Implement;

import com.misiontic.proyectovity.Services.CitasService;
import com.misiontic.proyectovity.Dao.CitasDao;
import com.misiontic.proyectovity.Models.Citas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class CitasServiceImpl implements CitasService{
    @Autowired
    private CitasDao citasDao;
    
    @Override
    @Transactional(readOnly=false)
    public Citas save(Citas citas){
        return citasDao.save(citas);
    }
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id){
        citasDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly=true)
    public Citas findById(Integer id){
        return citasDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Citas> findAll(){
        return (List<Citas>) citasDao.findAll();
    }
}
