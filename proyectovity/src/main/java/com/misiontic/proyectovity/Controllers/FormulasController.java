package com.misiontic.proyectovity.Controllers;

import com.misiontic.proyectovity.Models.Formulas;
import com.misiontic.proyectovity.Services.FormulasService;
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
@RequestMapping("/formulas")

public class FormulasController {
    @Autowired
    private FormulasService formulasservice;
    
    @PostMapping(value="/")
    public ResponseEntity<Formulas> agregar(@RequestBody Formulas formulas){
        Formulas obj = formulasservice.save(formulas);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Formulas> eliminar(@PathVariable Integer id){
        Formulas obj = formulasservice.findById(id);
        if(obj!=null)
            formulasservice.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Formulas> editar(@RequestBody Formulas formulas){
        Formulas obj = formulasservice.findById(formulas.getIdFormulas());
        if(obj!=null){
            obj.setIdEspecialista(formulas.getIdEspecialista());
            obj.setIdUsuario(formulas.getIdUsuario());
            obj.setIdMedicamento(formulas.getIdMedicamento());
            obj.setCantidad(formulas.getCantidad());
            obj.setEstado(formulas.getEstado());
            formulasservice.save(obj);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Formulas> consultarTodo(){
        return formulasservice.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Formulas consultarPorId(@PathVariable Integer id){
        return formulasservice.findById(id);
    }
}
