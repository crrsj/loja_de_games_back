package com.games.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.games.dto.AtualizarDto;
import com.games.dto.GameDto;
import com.games.entity.Game;
import com.games.repository.GameRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameService {
	
	private final GameRepository gameRepository;
	
	public Game cadastrarJogo(GameDto game) {
		var cadastrar = new Game(game);
		return gameRepository.save(cadastrar);
	}

	public List<Game>listar(){
		return gameRepository.findAll();
	}
	public Game buscarPorId(Long id) {
		Optional<Game>busca = gameRepository.findById(id);
		return busca.orElseThrow();
		
	}
	public Game atualizar(AtualizarDto atualize,Long id) {
		var atualizando = new Game(atualize);
		atualizando.setId(id);		
		return gameRepository.save(atualizando);
	}
	
	public void excluir(Long id) {
	
		gameRepository.deleteById(id);
	}
}
