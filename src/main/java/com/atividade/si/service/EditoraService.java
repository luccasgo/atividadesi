package com.atividade.si.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.atividade.si.dao.EditoraDAO;
import com.atividade.si.model.Editora;


@Service
public class EditoraService {

	@Autowired
	private EditoraDAO dao;
	
	public Editora buscarPorNome(String nome) {
		try {
			Editora ed = null;
			if(!StringUtils.isEmpty(nome)) {
				ed = dao.findByNome(nome);
			}
			return ed;
			
		}catch(Exception e) {
			throw new NoResultException("Não existe editoras com este nome: " + nome);
		}
	}

	public Editora cadastrarEditora(Editora editora) {
		return dao.save(editora);
	}
}
