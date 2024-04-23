package com.games.infra;





import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErroTratado {
	
	private HttpStatus status;
	private String mensagem;
}
