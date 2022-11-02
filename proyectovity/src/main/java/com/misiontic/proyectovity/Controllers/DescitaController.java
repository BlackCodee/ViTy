package com.misiontic.proyectovity.Controllers;

import com.misiontic.proyectovity.Models.Descita;
import com.misiontic.proyectovity.Services.DescitaService;
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
@RequestMapping("/descita")

public class DescitaController {
    @Autowired
    private DescitaService descitaservice;
    
    @PostMapping(value="/")
    public ResponseEntity<Descita> agregar(@RequestBody Descita descita){
        Descita obj = descitaservice.save(descita);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Descita> eliminar(@PathVariable Integer id){
        Descita obj = descitaservice.findById(id);
        if(obj!=null)
            descitaservice.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Descita> editar(@RequestBody Descita descita){
        Descita obj = descitaservice.findById(descita.getId_descita());
        if(obj!=null){
            obj.setNombre(descita.getNombre());
            obj.setEstado(descita.getEstado());
            descitaservice.save(obj);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Descita> consultarTodo(){
        return descitaservice.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Descita consultarPorId(@PathVariable Integer id){
        return descitaservice.findById(id);
    }
}
