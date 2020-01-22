import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(private http:HttpClient) { }
  getAllProdutos(){
    let token = localStorage.getItem("MyToken");
    return this.http.get("http://localhost:8080/produto/todos?token="+token);
  }
}
