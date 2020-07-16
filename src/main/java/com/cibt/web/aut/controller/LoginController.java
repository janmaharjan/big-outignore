/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.aut.controller;

import com.cibt.web.core.controller.SiteController;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Maharjan
 */
@Controller
@RequestMapping(value="/login")
public class LoginController extends SiteController {

    public LoginController() {
        super("Login");
    }
   
    @GetMapping
   public String index()
   {
    return "login";
   }
   @GetMapping(value="/logout")
   public String logout(HttpSession session)
   {
       session.invalidate();
       return "redirect:/login";
   }
}
