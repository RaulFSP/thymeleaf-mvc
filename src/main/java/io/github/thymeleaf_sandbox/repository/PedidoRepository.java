/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package io.github.thymeleaf_sandbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.thymeleaf_sandbox.model.Pedido;

/**
 *
 * @author laptop
 */
public interface PedidoRepository extends JpaRepository< Pedido,Long>{

}
