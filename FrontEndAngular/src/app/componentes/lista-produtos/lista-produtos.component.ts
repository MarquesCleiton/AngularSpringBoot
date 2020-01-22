import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router'
import { Produto } from 'src/app/modal/Produto';
import { ProdutoService } from 'src/app/servicos/produto.service';
@Component({
  selector: 'app-lista-produtos',
  templateUrl: './lista-produtos.component.html',
  styleUrls: ['./lista-produtos.component.css']
})
export class ListaProdutosComponent implements OnInit {

  public lista:Produto[];

  constructor(private router:Router, private service:ProdutoService) { }

  ngOnInit() {
    if(localStorage.getItem("MyToken")){
      this.service.getAllProdutos().subscribe(
        (res:Produto[]) =>{
          this.lista = res;
        },
        (err) =>{
          this.router.navigate(['/login']);
        }
      )
    }else{
      alert("Você Precisa estar conectado para acessar essa página!")
      this.router.navigate(['/home']);
    }
  }

}
