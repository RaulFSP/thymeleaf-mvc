/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package io.github.thymeleaf_sandbox.model;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Administrator
 */
public record PedidoDTOCreate(
        @NotBlank(message = "{NotBlank.pedidoDTOCreate.nome}")
        String nome,
        @NotBlank(message = "{NotBlank.pedidoDTOCreate.urlProduto}")
        String urlProduto,
        @NotBlank(message = "{NotBlank.pedidoDTOCreate.urlImagem}")
        String urlImagem,
        @NotBlank(message = "{NotBlank.pedidoDTOCreate.descricao}")
        String descricao
        
        ) {

	

}
