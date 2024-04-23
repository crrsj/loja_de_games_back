package com.games.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.games.dto.AtualizarDto;
import com.games.dto.GameDto;
import com.games.service.GameService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("game")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class GameController {
	
	private final GameService gameService;
	
	@PostMapping
	public ResponseEntity<GameDto>cadastrar(@RequestBody @Valid GameDto game){
		var cadastre = gameService.cadastrarJogo(game);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("game/{id}")
		.buildAndExpand(cadastre.getId()).toUri();
		return ResponseEntity.created(uri).body(new GameDto(cadastre));
	}
    @GetMapping
	public ResponseEntity<List<GameDto>>listar(){
		var lista = gameService.listar().stream().map(GameDto::new).toList();
		return ResponseEntity.ok(lista);
	}
    
    @GetMapping("{id}")
    public ResponseEntity<?>buscarPorId(@PathVariable Long id){
    	var busca = gameService.buscarPorId(id);
    	return ResponseEntity.ok(new GameDto(busca));
    }
    
    @PutMapping("{id}")
    public ResponseEntity<AtualizarDto>atualizar(@RequestBody @Valid AtualizarDto atualizar,@PathVariable Long id){
    	var atualize = gameService.atualizar(atualizar, id);
    	return ResponseEntity.ok(new AtualizarDto(atualize));
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Void>deletar(@PathVariable Long id){
    	gameService.excluir(id);
    	return ResponseEntity.noContent().build();
    }
}
