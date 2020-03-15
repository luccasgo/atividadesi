package com.atividade.si.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atividade.si.dto.CadastrarEditarLivroDTO;
import com.atividade.si.model.Livro;
import com.atividade.si.service.LivroService;

import javassist.NotFoundException;

@RestController
@RequestMapping("livros")
public class LivroController {
	@Autowired
	private LivroService service;
	
	@PostMapping
	public ResponseEntity<CadastrarEditarLivroDTO> cadastrarLivro(@RequestBody CadastrarEditarLivroDTO dto){
		service.cadastrarLivro(dto);
		return new ResponseEntity<CadastrarEditarLivroDTO>(HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<CadastrarEditarLivroDTO> editarLivro(@RequestBody CadastrarEditarLivroDTO dto,@RequestParam Long id) throws NotFoundException{
		service.editarLivroPorId(dto, id);
		return new ResponseEntity<CadastrarEditarLivroDTO>(HttpStatus.OK);
	}
	
	@GetMapping("titulo")
	public ResponseEntity<Livro> buscarLivroPorTitulo (@RequestParam String titulo){
		return new ResponseEntity<Livro>(service.buscarLivroPorNome(titulo), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Livro>> buscarTodos(){
		return new ResponseEntity<List<Livro>>(service.buscarTodos(), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Livro> excluirPorId(@RequestParam Long id){
		service.excluirLivro(id);
		return new ResponseEntity<Livro>(HttpStatus.OK);
	}
}
