package com.atividade.si.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade.si.model.Editora;
import com.atividade.si.service.EditoraService;

import javassist.NotFoundException;

@RestController
@RequestMapping("editoras")
public class EditoraController {
	@Autowired
	private EditoraService service;
	
	@PostMapping
	public ResponseEntity<Editora> cadastrarEditora(@RequestBody Editora editora){
		service.cadastrarEditora(editora);
		return new ResponseEntity<Editora>(HttpStatus.CREATED);
	}
	
	@GetMapping("listar")
	public ResponseEntity<List<Editora>> buscarTodasEditoras(){
		return new ResponseEntity<List<Editora>>(service.buscarTodasEditoras(),HttpStatus.OK);
	}
	
	@GetMapping("nome")
	public ResponseEntity<Editora> buscarEditoraPorNome(String nome){
		return new ResponseEntity<Editora>(service.buscarPorNome(nome),HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Editora> buscarPorId(Long id) throws NotFoundException{
		return new ResponseEntity<Editora>(service.buscarPorId(id),HttpStatus.OK);
	}

}
	