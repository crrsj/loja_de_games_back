package com.games.dto;

import com.games.entity.Game;

import jakarta.validation.constraints.NotBlank;

public record GameDto(
		@NotBlank(message = "Não pode ser vazio")
		String nome,
		
		String imagem,
		@NotBlank(message = "Não pode ser vazio")
		String desenvolvedor,
		
		Double valor) {

	public GameDto(Game cadastre) {
	this(cadastre.getNome(),cadastre.getImagem(),cadastre.getDesenvolvedor(),cadastre.getValor());
	}

}
