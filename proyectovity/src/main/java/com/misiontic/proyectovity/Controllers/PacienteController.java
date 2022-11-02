package com.misiontic.proyectovity.Controllers;

import com.misiontic.proyectovity.Models.Paciente;
import com.misiontic.proyectovity.Services.PacienteService;
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
@RequestMapping("/paciente")

public class PacienteController {
    @Autowired
    private PacienteService especialistaservice;
    
    @PostMapping(value="/")
    public ResponseEntity<Paciente> agregar(@RequestBody Paciente paciente){
        Paciente obj = especialistaservice.save(paciente);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Paciente> eliminar(@PathVariable Integer id){
        Paciente obj = especialistaservice.findById(id);
        if(obj!=null)
            especialistaservice.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Paciente> editar(@RequestBody Paciente paciente){
        Paciente obj = especialistaservice.findById(paciente.getIdp());
        if(obj!=null){
            obj.setDocumento(paciente.getDocumento());
            obj.setNombrePaciente(paciente.getNombrePaciente());
            obj.setTelefono(paciente.getTelefono());
            obj.setCorreo(paciente.getCorreo());
            especialistaservice.save(obj);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Paciente> consultarTodo(){
        return especialistaservice.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Paciente consultarPorId(@PathVariable Integer id){
        return especialistaservice.findById(id);
    }
}
