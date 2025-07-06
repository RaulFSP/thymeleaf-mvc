/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.thymeleaf_sandbox.authentication;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



/**
 *
 * @author Administrator
 */
public interface AppUserRepository extends JpaRepository<AppUser, String> {

    Optional<AppUser> findByUsername(String username);
}
