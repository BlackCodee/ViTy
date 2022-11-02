package com.misiontic.proyectovity.Controllers;

import com.misiontic.proyectovity.Models.Rol;
import com.misiontic.proyectovity.Services.RolService;
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
@RequestMapping("/rol")

public class RolController {
    @Autowired
    private RolService rolservice;
    
    @PostMapping(value="/")
    public ResponseEntity<Rol> agregar(@RequestBody Rol rol){
        Rol obj = rolservice.save(rol);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Rol> eliminar(@PathVariable Integer id){
        Rol obj = rolservice.findById(id);
        if(obj!=null)
            rolservice.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Rol> editar(@RequestBody Rol rol){
        Rol obj = rolservice.findById(rol.getIdRol());
        if(obj!=null){
            obj.setNombreRol(rol.getNombreRol());
            obj.setDescripcion(rol.getDescripcion());
            obj.setEstado(rol.getEstado());
            rolservice.save(obj);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Rol> consultarTodo(){
        return rolservice.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Rol consultarPorId(@PathVariable Integer id){
        return rolservice.findById(id);
    }
}
