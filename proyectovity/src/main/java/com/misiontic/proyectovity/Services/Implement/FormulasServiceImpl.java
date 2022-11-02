package com.misiontic.proyectovity.Services.Implement;

import com.misiontic.proyectovity.Services.FormulasService;
import com.misiontic.proyectovity.Dao.FormulasDao;
import com.misiontic.proyectovity.Models.Formulas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class FormulasServiceImpl implements FormulasService{
    @Autowired
    private FormulasDao formulasDao;
    
    @Override
    @Transactional(readOnly=false)
    public Formulas save(Formulas formulas){
        return formulasDao.save(formulas);
    }
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id){
        formulasDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly=true)
    public Formulas findById(Integer id){
        return formulasDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Formulas> findAll(){
        return (List<Formulas>) formulasDao.findAll();
    }
}
