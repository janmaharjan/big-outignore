/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.master.controller;

import com.cibt.web.core.controller.CRUDController;
import com.cibt.web.core.controller.SiteController;
import com.cibt.web.master.entity.Disease;
import com.cibt.web.master.repository.SeasonRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Maharjan
 */
@Controller
@RequestMapping(value="/diseases")
public class DiseaseController extends CRUDController<Disease, Integer> {

    public DiseaseController() {
        super("Diseases","master","diseases");
        this.viewPath="diseases";
    }
    
    
    
    
    
}
