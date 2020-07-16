/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Maharjan
 */
@SpringBootApplication
public class AppRunner {
    public static void main(String[] args) {
        
        SpringApplication.run(AppRunner.class, args);
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        System.out.println("this is"+encoder.encode("admin1234"));
    }
}
