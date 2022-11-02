package com.misiontic.proyectovity.Controllers;

import com.misiontic.proyectovity.Models.Usuario;
import com.misiontic.proyectovity.Services.UsuarioService;
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
@RequestMapping("/usuario")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioservice;
    
    @PostMapping(value="/")
    public ResponseEntity<Usuario> agregar(@RequestBody Usuario usuario){
        Usuario obj = usuarioservice.save(usuario);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Usuario> eliminar(@PathVariable Integer id){
        Usuario obj = usuarioservice.findById(id);
        if(obj!=null)
            usuarioservice.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Usuario> editar(@RequestBody Usuario usuario){
        Usuario obj = usuarioservice.findById(usuario.getIdUsuario());
        if(obj!=null){
            obj.setDocumento(usuario.getDocumento());
            obj.setNombreUsuario(usuario.getNombreUsuario());
            obj.setEstado(usuario.getEstado());
            obj.setTelefono(usuario.getTelefono());
            obj.setCorreo(usuario.getCorreo());
            obj.setTipo(usuario.getTipo());
            obj.setClave(usuario.getClave());
            obj.setIdRol(usuario.getIdRol());
            usuarioservice.save(obj);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Usuario> consultarTodo(){
        return usuarioservice.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Usuario consultarPorId(@PathVariable Integer id){
        return usuarioservice.findById(id);
    }
}
