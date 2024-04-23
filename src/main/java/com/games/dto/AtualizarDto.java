package com.games.dto;

import com.games.entity.Game;

public record AtualizarDto(Long id, String nome,String desenvolvedor,double valor) {

	public AtualizarDto(Game atualize) {
		this(atualize.getId(),atualize.getNome(),atualize.getDesenvolvedor(),atualize.getValor());
	}

}
