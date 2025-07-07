/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.thymeleaf_sandbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import io.github.thymeleaf_sandbox.authentication.AppUser;
import io.github.thymeleaf_sandbox.authentication.AppUserRepository;
import io.github.thymeleaf_sandbox.model.Pedido;
import io.github.thymeleaf_sandbox.model.PedidoDTOCreate;
import io.github.thymeleaf_sandbox.repository.PedidoRepository;

/**
 *
 * @author laptop
 */
@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    

    public ModelAndView getPedido(ModelAndView mv){
        mv.setViewName("pedido");
        return mv;
    }

    public String novoPedido(PedidoDTOCreate dto,BindingResult result){
        if(result.hasErrors()){
            return "pedido";
        }
        AppUser user = appUserRepository.getReferenceById(SecurityContextHolder.getContext().getAuthentication().getName());
        Pedido pedido = new Pedido(dto);
        pedido.setUser(user);
        pedidoRepository.save(pedido);
        return "redirect:/pedido";
    }

    
    
}
