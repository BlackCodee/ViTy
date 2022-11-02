package com.misiontic.proyectovity.Services.Implement;

import com.misiontic.proyectovity.Services.MedicamentoService;
import com.misiontic.proyectovity.Dao.MedicamentoDao;
import com.misiontic.proyectovity.Models.Medicamento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class MedicamentoServiceImpl implements MedicamentoService{
    @Autowired
    private MedicamentoDao medicamentoDao;
    
    @Override
    @Transactional(readOnly=false)
    public Medicamento save(Medicamento medicamento){
        return medicamentoDao.save(medicamento);
    }
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id){
        medicamentoDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly=true)
    public Medicamento findById(Integer id){
        return medicamentoDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Medicamento> findAll(){
        return (List<Medicamento>) medicamentoDao.findAll();
    }
}
