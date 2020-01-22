package br.org.generation.cleiton.backEndProdutos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.cleiton.backEndProdutos.model.Usuario;
import br.org.generation.cleiton.backEndProdutos.security.Autenticador;
import br.org.generation.cleiton.backEndProdutos.security.Token;

@RestController
@CrossOrigin("*")
public class UsuarioController {
	@PostMapping("/login")
	public ResponseEntity<Token> autentica(@RequestBody Usuario usuario) {
		if (usuario.getEmail().equals("cleiton@gmail.com") && usuario.getSenha().equals("1234")) {
			
			// simulando q recuperei o usuário do banco de dados
			usuario.setId(1);
			usuario.setNome("Cleiton Marques");
			
			String tk = Autenticador.generateToken(usuario);
			Token token = new Token();
			token.setStrToken(tk);
			return ResponseEntity.ok(token);
			
		} else {
			return ResponseEntity.status(403).build();
		}
	}
}
