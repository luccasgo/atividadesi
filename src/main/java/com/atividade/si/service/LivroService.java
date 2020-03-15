package com.atividade.si.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade.si.dao.LivroDAO;
import com.atividade.si.dto.CadastrarEditarLivroDTO;
import com.atividade.si.mapper.LivroMapper;
import com.atividade.si.model.Livro;

import javassist.NotFoundException;

@Service
public class LivroService {
	@Autowired
	private LivroDAO dao;

	public Livro cadastrarLivro(CadastrarEditarLivroDTO dto) {
		Livro livro = LivroMapper.mapper(dto);
		return dao.save(livro);
	}

	public Livro editarLivroPorId(CadastrarEditarLivroDTO dto, Long id) throws NotFoundException {
		Livro livro = dao.findById(id).orElseThrow(() -> new NotFoundException("Livro não existe para ser editado."));
		Livro livroTemp = LivroMapper.mapper(dto, livro);
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
}
