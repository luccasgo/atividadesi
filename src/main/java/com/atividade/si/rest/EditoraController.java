package com.atividade.si.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade.si.model.Editora;
import com.atividade.si.service.EditoraService;

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
}
	