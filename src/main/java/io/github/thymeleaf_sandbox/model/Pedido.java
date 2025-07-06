/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thymeleaf_sandbox.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.ColumnDefault;

import io.github.thymeleaf_sandbox.authentication.AppUser;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author laptop
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal valor;
    private LocalDate dataEntrega;
    private String urlProduto;
    private String urlImagem;
    @Lob
    private String descricao;

    @Enumerated(EnumType.STRING)
    @ColumnDefault(value="AGUARDANDO")
    private StatusPedido statusPedido;

    @ManyToOne
    @JoinColumn(name="username")
    private AppUser user;


    public Pedido(@Valid PedidoDTOCreate dto){
        this.nome=dto.nome();
        this.urlProduto=dto.urlProduto();
        this.urlImagem=dto.urlImagem();
        this.descricao=dto.descricao();
        this.statusPedido = StatusPedido.AGUARDANDO;
    }
}
