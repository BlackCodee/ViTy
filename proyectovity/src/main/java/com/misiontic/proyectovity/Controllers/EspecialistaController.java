package com.misiontic.proyectovity.Controllers;

import com.misiontic.proyectovity.Models.Especialista;
import com.misiontic.proyectovity.Services.EspecialistaService;
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
@RequestMapping("/especialista")

public class EspecialistaController {
    @Autowired
    private EspecialistaService especialistaservice;
    
    @PostMapping(value="/")
    public ResponseEntity<Especialista> agregar(@RequestBody Especialista especialista){
        Especialista obj = especialistaservice.save(especialista);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Especialista> eliminar(@PathVariable Integer id){
        Especialista obj = especialistaservice.findById(id);
        if(obj!=null)
            especialistaservice.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Especialista> editar(@RequestBody Especialista especialista){
        Especialista obj = especialistaservice.findById(especialista.getIde());
        if(obj!=null){
            obj.setDocumento(especialista.getDocumento());
            obj.setNombreEspecialista(especialista.getNombreEspecialista());
            obj.setTelefono(especialista.getTelefono());
            obj.setCorreo(especialista.getCorreo());
            especialistaservice.save(obj);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Especialista> consultarTodo(){
        return especialistaservice.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Especialista consultarPorId(@PathVariable Integer id){
        return especialistaservice.findById(id);
    }
}
