package com.camera.trigger.controller;
import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.camera.trigger.model.Usuario;
import com.camera.trigger.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class IndexController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	/* Isso é um serviço Restful */
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity init() {
	
		Iterable<Usuario> usuarios = usuarioRepository.findAll();

		// Cosome menos memória
		return new ResponseEntity(usuarios.iterator(), HttpStatus.OK);
	}

	/* Isso é um serviço Restful */
    @GetMapping(value="/{id}", produces = "application/json")
    public ResponseEntity get(@PathVariable(value="id") Long id){
        // System.out.println(null);
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return new ResponseEntity(usuario.get(), HttpStatus.OK);
	}

	/* Isso é um serviço Restful */
    @GetMapping(value="/{id}/relatorio/{dias}", produces = "application/json")
    public ResponseEntity get(@PathVariable(value="id") Long id, @PathVariable(value="dias") Long dias){
        // System.out.println(null);
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return new ResponseEntity(usuario.get(), HttpStatus.OK);
	}

	/* inserir */
	@PostMapping(value="/", produces = "application/json")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){

		for (int pos = 0; pos < usuario.getTelefones().size(); pos++){
			usuario.getTelefones().get(pos).setUsuario(usuario);
		}

		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		return new ResponseEntity(usuarioSalvo, HttpStatus.OK);
		
	}

	/* Modificar */
	@PutMapping(value="/", produces = "application/json")
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario){

		for (int pos = 0; pos < usuario.getTelefones().size(); pos++){
			usuario.getTelefones().get(pos).setUsuario(usuario);
		}

		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		return new ResponseEntity(usuarioSalvo, HttpStatus.OK);
	}	

	/* Deletar um usuario */
	@DeleteMapping(value="/{id}", produces = "application/json")
	public String deletar(@PathVariable Long id){
		usuarioRepository.deleteById(id);
		return "ok";
	}	

	
}