/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  natan
 * Created: Jul 4, 2018
 */

insert into cliente (id, nome) values (1, 'Eletronicos Eletro');
insert into cliente (id, nome) values (2, 'Smart Compras');

insert into produto (id, nome, valor) values (1, 'Notebook', 2950.0);
insert into produto (id, nome, valor) values (2, 'Smartphone', 1800.0);
insert into produto (id, nome, valor) values (3, 'Tablet', 1100.0);

insert into venda (id, cliente_id, frete, total, cadastro) values (1, 1, 15.0, 2965.0, sysdate());
insert into item (id, venda_id, produto_id, quantidade) values (1, 1, 1, 1);



