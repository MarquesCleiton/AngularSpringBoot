import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { Usuario } from 'src/app/modal/Usuario';
import { UsuarioService } from 'src/app/servicos/usuario.service';
import { MyToken } from 'src/app/modal/MyToken';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private usuario:Usuario = new Usuario();

  constructor(private service:UsuarioService, private router:Router) { }

  ngOnInit() {
    if(localStorage.getItem("Mytoken")){
      this.router.navigate(['/lista'])
    }
  }

  enviarDados(){
    this.service.autenticar(this.usuario).subscribe(
      (res: MyToken)=>{
        // se deu certo        
        // armazeno o token no LocalStorage
        localStorage.setItem("MyToken",res.strToken);
        // navego para a página LISTAGEM
        this.router.navigate(['/lista']);

      },
      (err)=>{
        alert("FAIL!!!")
      }
    );
  }
}
