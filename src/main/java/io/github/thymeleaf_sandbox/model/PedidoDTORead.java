/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package io.github.thymeleaf_sandbox.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author laptop
 */
public record PedidoDTORead(
        Long id,
        String nome,
        BigDecimal valor,
        LocalDate dataEntrega,
        String urlProduto,
        String urlImagem,
        String descricao
        ) {

            public PedidoDTORead(Pedido pedido){
                this(pedido.getId(),pedido.getNome(),pedido.getValor(),pedido.getDataEntrega(),pedido.getUrlProduto(),pedido.getUrlImagem(),pedido.getDescricao());
            }
}
