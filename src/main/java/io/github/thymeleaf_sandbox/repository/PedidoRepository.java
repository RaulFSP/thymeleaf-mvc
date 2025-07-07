/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.thymeleaf_sandbox.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.thymeleaf_sandbox.authentication.AppUser;
import io.github.thymeleaf_sandbox.model.Pedido;
import io.github.thymeleaf_sandbox.model.enums.StatusPedido;

/**
 *
 * @author laptop
 */
public interface PedidoRepository extends JpaRepository< Pedido, Long> {

    Page<Pedido> findByStatusPedido(StatusPedido status, Pageable pageable);

    Page<Pedido> findAllByUser(AppUser user, Pageable pageable);

    @Query("SELECT p FROM Pedido p join p.user u where u.username =:username")
    Page<Pedido> findAllByUser(@Param("username") String username, Pageable pageable);

    @Query("""
            select p from Pedido p join p.user u where p.statusPedido =:status and u.username=:username
            """)
    Page<Pedido> findAllByStatusPedidoUser(@Param("username") String username, @Param("status") StatusPedido status, Pageable pageable);
}
