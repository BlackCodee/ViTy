package com.misiontic.proyectovity.Controllers;

import com.misiontic.proyectovity.Models.Medicamento;
import com.misiontic.proyectovity.Services.MedicamentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/medicamento")

public class MedicamentoController {
    @Autowired
    private MedicamentoService medicamentoservice;
    
    @PostMapping(value="/")
    public ResponseEntity<Medicamento> agregar(@RequestBody Medicamento medicamento){
        Medicamento obj = medicamentoservice.save(medicamento);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Medicamento> eliminar(@PathVariable Integer id){
        Medicamento obj = medicamentoservice.findById(id);
        if(obj!=null)
            medicamentoservice.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Medicamento> editar(@RequestBody Medicamento medicamento){
        Medicamento obj = medicamentoservice.findById(medicamento.getIdMedicamento());
        if(obj!=null){
            obj.setNombreMedicamento(medicamento.getNombreMedicamento());
            obj.setNombreCientifico(medicamento.getNombreCientifico());
            obj.setConcentracion(medicamento.getConcentracion());
            obj.setCantidad(medicamento.getCantidad());
            obj.setEstado(medicamento.getEstado());
            medicamentoservice.save(obj);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Medicamento> consultarTodo(){
        return medicamentoservice.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Medicamento consultarPorId(@PathVariable Integer id){
        return medicamentoservice.findById(id);
    }
}
