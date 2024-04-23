package com.games.entity;

import com.games.dto.AtualizarDto;
import com.games.dto.GameDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "games")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String imagem;
	private String desenvolvedor;
	private Double valor;
	
	public Game(GameDto game) {
		this.nome = game.nome();
		this.imagem = game.imagem();
		this.desenvolvedor = game.desenvolvedor();
		this.valor = game.valor();
	}

	public Game(AtualizarDto atualize) {
	this.id = atualize.id();
	this.nome = atualize.nome();
	this.desenvolvedor = atualize.desenvolvedor();
	this.valor = atualize.valor();
	}
}
