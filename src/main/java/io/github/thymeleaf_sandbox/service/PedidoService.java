/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.thymeleaf_sandbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import io.github.thymeleaf_sandbox.model.Pedido;
import io.github.thymeleaf_sandbox.model.PedidoDTOCreate;
import io.github.thymeleaf_sandbox.model.PedidoDTORead;
import io.github.thymeleaf_sandbox.repository.PedidoRepository;

/**
 *
 * @author laptop
 */
@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public ModelAndView getHome(ModelAndView mv){
        List<PedidoDTORead> pedidos = pedidoRepository.findAll().stream().map(PedidoDTORead::new).toList();
        mv.addObject("pedidos", pedidos);
        mv.setViewName("home");
        return mv;
    }

    public ModelAndView getPedido(ModelAndView mv){
        mv.setViewName("pedido");
        return mv;
    }

    public void novoPedido(PedidoDTOCreate dto){
        
        pedidoRepository.save(new Pedido(dto));
        
    }
}
