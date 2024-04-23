package com.games.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.games.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
