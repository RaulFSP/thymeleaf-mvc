/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.thymeleaf_sandbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import io.github.thymeleaf_sandbox.model.PedidoDTOCreate;
import io.github.thymeleaf_sandbox.service.PedidoService;
import jakarta.validation.Valid;



/**
 *
 * @author laptop
 */
@Controller
@RequestMapping(value="/pedido")
public class PedidoController {

@Autowired
private PedidoService pedidoService;

    @GetMapping
    public ModelAndView pedido(ModelAndView mv) {
        return pedidoService.getPedido(mv);
    }
    
    @PostMapping("/novo")
    public String pedidoNovo(@Valid PedidoDTOCreate dto, BindingResult result) {
        if(result.hasErrors()){
            return "pedido";
        }
        pedidoService.novoPedido(dto);
        return "redirect:/pedido";
    }
    
}
