/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thymeleaf_sandbox.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import io.github.thymeleaf_sandbox.service.HomeService;
import jakarta.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping
    public ModelAndView home(HttpServletRequest req,ModelAndView mv, Principal principal, @PageableDefault(size=5,page=0) Pageable pageable) {
        return homeService.getHome(req,mv,principal,pageable);
    }

    @GetMapping("/{statusPedido}")
    public ModelAndView homeAguardando(HttpServletRequest req,@PathVariable String statusPedido,Principal principal,ModelAndView mv,@PageableDefault(size=5,page=0) Pageable pageable) {
        return homeService.getPedidos(req,principal,statusPedido,mv,pageable);
    }
    
}
