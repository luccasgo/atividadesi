package com.atividade.si.mapper;

import com.atividade.si.dto.CadastrarEditarLivroDTO;
import com.atividade.si.model.Editora;
import com.atividade.si.model.Livro;

public class LivroMapper {

	public static Livro mapper(CadastrarEditarLivroDTO dto, Editora editora) {
		Livro livro = new Livro();
		livro.setEditora(editora);
		livro.setQuantidadePaginas(dto.getQuantidadePaginas());
		livro.setTitulo(dto.getTitulo());
		return livro;
	}

	public static Livro mapper(CadastrarEditarLivroDTO dto, Livro livro, Editora editora) {
		if (!dto.getEditora().equals(null)) {
			livro.setEditora(editora);
		}
		if (!dto.getQuantidadePaginas().equals(null)) {
			livro.setQuantidadePaginas(dto.getQuantidadePaginas());
		}
		if (!dto.getTitulo().equals(null)) {
			livro.setTitulo(dto.getTitulo());
		}
		return livro;
	}
}
