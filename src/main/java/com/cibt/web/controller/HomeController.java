/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.controller;

import com.cibt.web.core.controller.SiteController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Maharjan
 */
@Controller
@RequestMapping(value="/")
public class HomeController extends SiteController{

    public HomeController() {
        super("Home","Home");
    }
    
    @GetMapping
    public String index()
    {
        return "index";
    }
}
