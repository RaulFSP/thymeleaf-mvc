/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thymeleaf_sandbox.service;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import io.github.thymeleaf_sandbox.model.PedidoDTORead;
import io.github.thymeleaf_sandbox.model.enums.StatusPedido;
import io.github.thymeleaf_sandbox.repository.PedidoRepository;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrator
 */
@Service
public class HomeService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public ModelAndView getHome(HttpServletRequest req, ModelAndView mv, Principal principal, Pageable pageable) {
        Page<PedidoDTORead> pedidos = pedidoRepository.findAllByUser(principal.getName(), pageable).map(PedidoDTORead::new);
        String currentUrl = req.getRequestURL().toString();
        mv.addObject("pedidos", pedidos);
        mv.addObject("currentUrl", currentUrl);
        mv.setViewName("home");
        return mv;
    }

    public ModelAndView getPedidos(HttpServletRequest req, Principal principal, String status, ModelAndView mv, Pageable pageable) {
        Page<PedidoDTORead> pedidos = pedidoRepository.findAllByStatusPedidoUser(
                principal.getName(),
                StatusPedido.valueOf(status.toUpperCase()),
                pageable).map(PedidoDTORead::new);
        String currentUrl = req.getRequestURL().toString();
        mv.addObject("currentUrl", currentUrl);
        mv.addObject("pedidos", pedidos);
        mv.setViewName("home");
        return mv;
    }
}
