package br.org.generation.cleiton.backEndProdutos.security;

import br.org.generation.cleiton.backEndProdutos.model.Usuario;
import javax.xml.bind.DatatypeConverter;
public class Autenticador {
	//Prefixo inicial do nosso token
	private static final String PREFIXO="*CLEITON;";
	public static String generateToken(Usuario usuario){
		//concatena o prefixo com as informações do usuario;
		String str = PREFIXO + usuario.toString();
		//converte para hexadecial
		
		String token = DatatypeConverter.printHexBinary(str.getBytes());
		return token;
	}
	
	public static boolean isValid(String token) {
		byte[] vetor = DatatypeConverter.parseHexBinary(token);
		//converte o código hexadecimal de volta para texto
	    String novaString = new String(vetor);
	    if (novaString.startsWith(PREFIXO)) {
	    	return true;
	    }
	    return false;
	}
	
	public static Usuario getUser(String token) {
		byte[] vetor = DatatypeConverter.parseHexBinary(token);
		//converte o código hexadecimal de volta para texto
	    String novaString = new String(vetor);
	    String partes[] = novaString.split(";");
	    
	    Usuario u = new Usuario();
	    u.setId(Integer.parseInt(partes[1]));
	    u.setNome(partes[2]);
	    u.setEmail(partes[3]);
	    return u;
	}
}
