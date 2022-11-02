package com.misiontic.proyectovity.Controllers;

import com.misiontic.proyectovity.Models.Citas;
import com.misiontic.proyectovity.Services.CitasService;
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
@RequestMapping("/citas")

public class CitasController {
    @Autowired
    private CitasService citasservice;
    
    @PostMapping(value="/")
    public ResponseEntity<Citas> agregar(@RequestBody Citas citas){
        Citas obj = citasservice.save(citas);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Citas> eliminar(@PathVariable Integer id){
        Citas obj = citasservice.findById(id);
        if(obj!=null)
            citasservice.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Citas> editar(@RequestBody Citas citas){
        Citas obj = citasservice.findById(citas.getIdc());
        if(obj!=null){
            obj.setFecha(citas.getFecha());
            obj.setNombrePaciente(citas.getNombrePaciente());
            obj.setNombreEspecialista(citas.getNombreEspecialista());
            obj.setDetalle(citas.getDetalle());
            citasservice.save(obj);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Citas> consultarTodo(){
        return citasservice.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Citas consultarPorId(@PathVariable Integer id){
        return citasservice.findById(id);
    }
}
