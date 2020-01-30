import { Component, OnInit } from '@angular/core';
import { Globals } from '../../modal/Globals';
import { Usuario } from '../../modal/Usuario';
import { UsuarioService } from '../../servicos/usuario.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
  providers: [ Globals ]
})
export class NavbarComponent implements OnInit {
  private user:Usuario;
  constructor(private userSrv: UsuarioService) { 
    
  }
  ngOnInit() {
    this.userSrv.buscarInfo(localStorage.getItem("MyToken")).subscribe(
      (res: Usuario) => {
        Globals.usuario = res;
        this.user = res;
          console.log("USER INFO...");
          console.log(res);
      },
      (err) => {
        console.log("ERRO!!!");
      }
    );
  }

}
