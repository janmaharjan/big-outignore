/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.aut.controller;

import com.cibt.web.aut.entity.User;
import com.cibt.web.aut.repository.RoleRepository;
import com.cibt.web.core.controller.CRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Maharjan
 */
@Controller
@RequestMapping(value="/users")
public class UserController extends CRUDController<User, Integer>{

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private RoleRepository roleRepository; 
    public UserController() {
        super("User","auth","users");
        viewPath="users";
    }
    @Override
    public String create(Model model) {
        model.addAttribute("roles", roleRepository.findAll());
        return super.create(model);
    }

    @Override
    public String save(User entity) {
        entity.setPassword(encoder.encode(entity.getPassword()));
        return super.save(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String edit(@PathVariable("id")Integer id, Model model) {
      model.addAttribute("roles", roleRepository.findAll());
      return super.edit(id,model);
    }
    
}
