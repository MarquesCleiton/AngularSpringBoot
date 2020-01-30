import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router'
import { Produto } from 'src/app/modal/Produto';
import { ProdutoService } from 'src/app/servicos/produto.service';
import { UsuarioService } from '../../servicos/usuario.service';
import { Usuario } from '../../modal/Usuario';
import { Globals } from '../../modal/Globals';

@Component({
  selector: 'app-lista-produtos',
  templateUrl: './lista-produtos.component.html',
  styleUrls: ['./lista-produtos.component.css'],
  providers: [ Globals ]
})
export class ListaProdutosComponent implements OnInit {

  public lista:Produto[];

  constructor(private router:Router, private service:ProdutoService, private userSrv: UsuarioService) { }

  ngOnInit() {
    if(localStorage.getItem("MyToken")){
      this.service.getAllProdutos().subscribe(
        (res:Produto[]) =>{
          this.lista = res;
        },
        (err) =>{
          this.router.navigate(['/login']);
        }
      );
      this.userSrv.buscarInfo(localStorage.getItem("MyToken")).subscribe(
        (res: Usuario) => {
          Globals.usuario = res;
            console.log("USER INFO...");
            console.log(res);
        },
        ( err) => {
          console.log("ERRO!!!");
        }
      );

    }else{
      alert("Você Precisa estar conectado para acessar essa página!")
      this.router.navigate(['/home']);
    }
  }

}
