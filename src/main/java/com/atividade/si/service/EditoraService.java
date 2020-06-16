package com.atividade.si.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade.si.dao.EditoraDAO;
import com.atividade.si.model.Editora;

import javassist.NotFoundException;


@Service
public class EditoraService {

	@Autowired
	private EditoraDAO dao;
	
	public Editora buscarPorNome(String nome) {
		try {
			return dao.findByNomeContaining(nome);
						
		}catch(Exception e) {
			throw new NoResultException("Não existe editoras com este nome: " + nome);
		}
	}
	
	public Editora buscarPorId(Long id) throws NotFoundException {
		Editora ed = dao.findById(id).orElseThrow(() -> new NotFoundException("Editora não encontrada"));
		return ed;
	}

	public Editora cadastrarEditora(Editora editora) {
		return dao.save(editora);
	}
	
	public List<Editora> buscarTodasEditoras(){
		return dao.findAll();
	}
}
