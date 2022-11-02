package com.misiontic.proyectovity.Services.Implement;

import com.misiontic.proyectovity.Services.PacienteService;
import com.misiontic.proyectovity.Dao.PacienteDao;
import com.misiontic.proyectovity.Models.Paciente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class PacienteServiceImpl implements PacienteService{
    
    @Autowired
    private PacienteDao pacienteDao;
    
    @Override
    @Transactional(readOnly=false)
    public Paciente save(Paciente paciente){
        return pacienteDao.save(paciente);
    }
    
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id){
        pacienteDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly=true)
    public Paciente findById(Integer id){
        return pacienteDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Paciente> findAll(){
        return (List<Paciente>) pacienteDao.findAll();
    }
    
}
