package com.camera.trigger.controller;
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

@RestController			/* Essa já é nossa arquitetura REST */
@RequestMapping(value = "/usuario")
public class IndexController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	/* Serviços RESTful */
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Usuario> init(@PathVariable(value="id") Long id) {

		Optional<Usuario> usuario = usuarioRepository.findById(id);

		return new ResponseEntity(usuario.get(), HttpStatus.OK);
	}

	@GetMapping(value="/", produces = "application/json")
	public ResponseEntity<List<Usuario>> usuario(){
		List<Usuario> list = (List<Usuario>) usuarioRepository.findAll();

		return new ResponseEntity(list, HttpStatus.OK);
	}


	@GetMapping(value = "/{id}/relatorio/{dias}", produces = "application/json")
	public ResponseEntity<Usuario> test(@PathVariable(value="id") Long id,
										@PathVariable(value="dias") Long dias) {
		
		return new ResponseEntity("Relatorio do user "+id+" dos ultimos "+dias+" dias", HttpStatus.OK);
	}	

	@PostMapping(value="/", produces = "application/json")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
		Usuario usuarioSalvo = usuarioRepository.save(usuario);

		return new ResponseEntity(usuarioSalvo, HttpStatus.OK);
	}

	@PutMapping(value="/", produces = "application/json")
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario){
		Usuario usuarioSalvo = usuarioRepository.save(usuario);		// O save já atualiza o objeto caso tenha um ID no JSON

		return new ResponseEntity(usuarioSalvo, HttpStatus.OK);
	}	

	@DeleteMapping(value="/{id}", produces = "application/text")
	public String deletar(@PathVariable("id") Long id){
		usuarioRepository.deleteById(id); 

		return "ok";
	}		


}