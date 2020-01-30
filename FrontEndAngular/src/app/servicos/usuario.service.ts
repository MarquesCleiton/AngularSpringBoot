import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../modal/Usuario';
@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }
  
  autenticar(usuario: Usuario) {
    return this.http.post("http://localhost:8080/login", usuario);
  }

  buscarInfo(token: string){
    return this.http.get("http://localhost:8080/userinfo?token="+token);
  }
}