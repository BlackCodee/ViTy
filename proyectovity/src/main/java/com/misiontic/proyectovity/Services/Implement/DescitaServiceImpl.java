package com.misiontic.proyectovity.Services.Implement;

import com.misiontic.proyectovity.Services.DescitaService;
import com.misiontic.proyectovity.Dao.DescitaDao;
import com.misiontic.proyectovity.Models.Descita;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class DescitaServiceImpl implements DescitaService{
    @Autowired
    private DescitaDao descitaDao;
    
    @Override
    @Transactional(readOnly=false)
    public Descita save(Descita descita){
        return descitaDao.save(descita);
    }
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id){
        descitaDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly=true)
    public Descita findById(Integer id){
        return descitaDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Descita> findAll(){
        return (List<Descita>) descitaDao.findAll();
    }
}
