/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.thymeleaf_sandbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import io.github.thymeleaf_sandbox.service.CadastroService;


/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping(value="/cadastro")
public class CadastroController {

@Autowired
private CadastroService cadastroService;

    @GetMapping
    public ModelAndView getMethodName(ModelAndView mv) {
        return cadastroService.getCadastro(mv);
    }
    
}
