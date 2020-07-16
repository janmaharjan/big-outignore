/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.aut.controller;

import com.cibt.web.aut.entity.Role;
import com.cibt.web.aut.repository.RoleRepository;
import com.cibt.web.core.controller.CRUDController;
import com.cibt.web.core.controller.SiteController;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Maharjan
 */
@Controller
@RequestMapping(value="/roles")
public class RolesController extends CRUDController<Role, Integer> {
    @Autowired
    private RoleRepository repository;
    public RolesController() {
        super("Role","auth","roles");
        this.viewPath="roles";
    } 
}
