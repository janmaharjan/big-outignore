/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.plant.controller;
import com.cibt.web.core.controller.CRUDController;
import com.cibt.web.core.controller.SiteController;
import com.cibt.web.master.entity.Season;
import com.cibt.web.master.repository.SeasonRepository;
import com.cibt.web.plant.entity.PlantType;
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
@RequestMapping(value="/plant_types")
public class PlantTypeController extends CRUDController<PlantType, Integer> {

    public PlantTypeController() {
        super("Plant Type","Plants","plant_types");
        this.viewPath="plant_types";
    }
    
    
    
    
    
}
