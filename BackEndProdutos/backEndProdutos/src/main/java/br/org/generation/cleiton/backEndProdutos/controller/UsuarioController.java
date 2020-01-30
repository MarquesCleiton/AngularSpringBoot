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
		Usuario u[] = new Usuario[2];
		u[0] = new Usuario();
		u[0].setNome("Cleiton");
		u[0].setEmail("cleiton@cleiton");
		u[0].setSenha("1");
		
		u[1] = new Usuario();
		u[1].setNome("teste");
		u[1].setEmail("teste@teste");
		u[1].setSenha("1");
		
		Usuario u2;
		
		boolean achou = false;
		
		for(int i = 0; i < u.length; i++) {
			if(u[i].getEmail().equals(usuario.getEmail()) && u[i].getSenha().equals(usuario.getSenha())) {
				achou = true;
				usuario.setId(1);
				usuario.setNome(u[i].getNome());
			}
		}
		
		if (achou) {
			// simulando q recuperei o usuário do banco de dados
			String tk = Autenticador.generateToken(usuario);
			Token token = new Token();
			token.setStrToken(tk);
			return ResponseEntity.ok(token);
			
		} else {
			return ResponseEntity.status(403).build();
		}
	}
}
