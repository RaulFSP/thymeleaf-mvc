/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.thymeleaf_sandbox.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

/**
 *
 * @author Administrator
 */
@ControllerAdvice
public class PageAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public String illegalArgumentException(){
        return "redirect:/home";
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public String noResourceFoundException(){
        return "redirect:/home";
    }
    
}
