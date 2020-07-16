/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.core.controller;

import com.cibt.web.master.entity.Season;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Maharjan
 */
public abstract class CRUDController<T,Id> extends SiteController {
   @Autowired
    protected JpaRepository<T, Id> repository;
   protected  String viewPath;

    public CRUDController() {
    }

    public CRUDController(String pageTitle,String activeMenu, String pageURI) {
        super(pageTitle,activeMenu,pageURI); 
    }
   
    @GetMapping()
    public String index(Model model)
    {
        model.addAttribute("records",repository.findAll());
        return viewPath+"/index";
    }
    @PostMapping()
    @Transactional
    public String save(T entity)
    {
        repository.save(entity);
        return "redirect:/"+pageURI+"?success";
    }
    @PostMapping("/json")
    @Transactional
    @ResponseBody
    public String saveJson(T entity)
    {
        repository.save(entity);
        return "success";
    }
    @GetMapping(value="/create")
    public String create(Model model)
    {
        return viewPath+"/create";
    }
    @GetMapping(value="/edit/{id}")
    public String edit(@PathVariable("id")Id id,Model model)
    {
        model.addAttribute("record",repository.findById(id).get());
        return viewPath+"/edit";
    }
    @GetMapping(value="/delete/{id}")
    @Transactional
    public String delete(@PathVariable("id")Id id)
    {
        repository.deleteById(id);
        return "redirect:/"+pageURI+"?sucess";
    }
     @GetMapping(value="/json")
     @ResponseBody
    public List<T> json(Model model)
    {
        return repository.findAll();
    }
    @GetMapping(value="/json/{id}")
     @ResponseBody
    public T json(@PathVariable("id")Id id)
    {
        return repository.findById(id).get();
    }

}
