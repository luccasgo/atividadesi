package com.atividade.si.dto;

import javax.validation.constraints.NotNull;

public class CadastrarEditarLivroDTO {
	private String titulo;
	@NotNull
	private String editora;
	private Integer quantidadePaginas;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public Integer getQuantidadePaginas() {
		return quantidadePaginas;
	}
	public void setQuantidadePaginas(Integer quantidadePaginas) {
		this.quantidadePaginas = quantidadePaginas;
	}
	
	
}
