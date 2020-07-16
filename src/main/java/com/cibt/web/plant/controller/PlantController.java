/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.plant.controller;
import com.cibt.web.core.controller.CRUDController;
import com.cibt.web.core.controller.SiteController;
import com.cibt.web.master.entity.Disease;
import com.cibt.web.master.repository.DiseaseRepository;
import com.cibt.web.plant.entity.Plant;
import com.cibt.web.plant.repository.PlantTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Maharjan
 */
@Controller
@RequestMapping(value="/plants")
public class PlantController extends CRUDController<Plant, Integer> {

    @Autowired
    private PlantTypeRepository typeRepository;
    @Autowired
    private DiseaseRepository diseaseRepository;
            
    public PlantController() {
        super("Plants","Plants","plants");
        this.viewPath="plants";
    }
     @Override
    public String create(Model model) {
         plantVariables(model);
      return super.create(model);
    }
     @Override
    public String edit(@PathVariable("id")Integer id, Model model) {
           plantVariables(model);
         return super.edit(id,model);
    }
    public void plantVariables(Model model)
    {
         model.addAttribute("types", typeRepository.findAll());
        model.addAttribute("diseases", diseaseRepository.findAll());
     }
    @GetMapping(value="/diseases/{plantId}")
    @ResponseBody
    public List<Disease> diseases(@PathVariable("plantId")int plantId)
    {
        return repository.findById(plantId).get().getDiseases();
    }
}
