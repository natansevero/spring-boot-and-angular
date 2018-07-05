import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormGroup } from '@angular/forms';

import { ClientesService } from '../clientes/clientes.service';
import { ProdutosService } from '../produtos/produtos.service';
import { VendasService } from '../vendas/vendas.service';

import { MessageService } from 'primeng/components/common/messageservice';

@Component({
  selector: 'app-venda-cadastro',
  templateUrl: './venda-cadastro.component.html',
  styleUrls: ['./venda-cadastro.component.css']
})
export class VendaCadastroComponent implements OnInit {

  venda: any;
  item: any;
  clientes: Array<any>;
  produtos: Array<any>; 
  @Output() vendaSalva = new EventEmitter();

  constructor(private clientesService: ClientesService, 
    private produtosService: ProdutosService, 
    private vendasService: VendasService,
    private messageService: MessageService) { }

  ngOnInit() {
    this.novaVenda();

    this.clientesService.listar()
      .subscribe(response => this.clientes = response);

    this.produtosService.listar()
      .subscribe(response => this.produtos = response);
  }

  novaVenda() {
    this.venda = { itens: [], frete: 0.0, total: 0.0 };
    this.item = {};
  }

  incluirItem() {
    this.item.total = this.item.produto.valor * this.item.quantidade;
    this.venda.itens.push(this.item);
    this.item = {};
    
    this.calcularTotal();
  }

  private calcularTotal() {
    const totalItems = this.venda.itens
      .map(i => (i.produto.valor * i.quantidade))
      .reduce((total, v) => total + v ,0);

    this.venda.total = totalItems + this.venda.frete;
  }

  adicionar(frm: FormGroup) {
    this.vendasService.adicionar(this.venda)
      .subscribe(response => {
        frm.reset();

        this.novaVenda();

        this.messageService.add({ severity: 'success', detail: 'Venda adicionada com sucesso!' })

        this.vendaSalva.emit(response);
      })
  }
}
