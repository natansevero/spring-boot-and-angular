import { Component, OnInit } from '@angular/core';

import { VendasService } from '../vendas/vendas.service';

@Component({
  selector: 'app-vendas-listagem',
  templateUrl: './vendas-listagem.component.html',
  styleUrls: ['./vendas-listagem.component.css']
})
export class VendasListagemComponent implements OnInit {

  vendas: Array<any>;

  constructor(private vendasService: VendasService) { }

  ngOnInit() {
    this.listar();
  }

  listar() {
    this.vendasService.listar()
    .subscribe(response => this.vendas = response);
  }
}
