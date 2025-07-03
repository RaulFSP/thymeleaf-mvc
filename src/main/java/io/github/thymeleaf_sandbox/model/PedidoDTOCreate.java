/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package io.github.thymeleaf_sandbox.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

/**
 *
 * @author Administrator
 */
public record PedidoDTOCreate(
        @NotEmpty
        String nome,
        @NotBlank
        String urlProduto,
        @NotBlank
        String urlImagem,
        @NotBlank
        String descricao
        ) {

}
