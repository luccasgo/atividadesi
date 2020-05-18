package com.atividade.si.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atividade.si.model.Editora;

@Repository
public interface EditoraDAO extends JpaRepository<Editora, Long>{
	public Editora findByNome(String nome);
}
