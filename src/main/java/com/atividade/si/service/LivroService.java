package com.atividade.si.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade.si.dao.LivroDAO;
import com.atividade.si.dto.CadastrarEditarLivroDTO;
import com.atividade.si.mapper.LivroMapper;
import com.atividade.si.model.Editora;
import com.atividade.si.model.Livro;

import javassist.NotFoundException;

@Service
public class LivroService {
	@Autowired
	private LivroDAO dao;
	@Autowired
	private EditoraService editoraService;

	public Livro cadastrarLivro(CadastrarEditarLivroDTO dto) {
		Editora ed = editoraService.buscarPorNome(dto.getEditora());
		Livro livro = LivroMapper.mapper(dto, ed);
		return dao.save(livro);
	}

	public Livro editarLivroPorId(CadastrarEditarLivroDTO dto, Long id) throws NotFoundException {
		Editora ed = editoraService.buscarPorNome(dto.getEditora());
		Livro livro = dao.findById(id).orElseThrow(() -> new NotFoundException("Livro não existe para ser editado."));
		Livro livroTemp = LivroMapper.mapper(dto, livro, ed);
		return dao.save(livroTemp);
	}

	public List<Livro> buscarTodos() {
		return dao.findAll();
	}

	public Livro buscarLivroPorNome(String nome) {
		return dao.findByTituloContaining(nome);
	}

	public void excluirLivro(Long id) {
		dao.deleteById(id);
	}
	
	public Optional<Livro> buscarLivroPorId(Long id) {
		return dao.findById(id);
	}
}
