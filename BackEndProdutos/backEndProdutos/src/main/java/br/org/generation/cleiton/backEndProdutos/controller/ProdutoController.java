package br.org.generation.cleiton.backEndProdutos.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.cleiton.backEndProdutos.model.Produto;
import br.org.generation.cleiton.backEndProdutos.security.Autenticador;

@RestController
@CrossOrigin("*")
public class ProdutoController {
	@GetMapping("/aluno/todos")
	public ResponseEntity<ArrayList<Produto>> getAllProducts(@RequestParam String token){
		ArrayList<Produto> lista = new ArrayList<Produto>();
		if(Autenticador.isValid(token)) {
			for(int i = 1; i <= 10; i++) {
				Produto p = new Produto();
				p.setCodigo(i*25);
				p.setTitulo("Produto "+i);
				p.setPreco(i*2.5f);
				p.setDetalhe("Teste do produto "+i);
			}
			return ResponseEntity.ok(lista);
		}else {
			return ResponseEntity.status(403).build();
		}
	}
}
