/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.plant.entity;

import com.cibt.web.core.entity.MasterEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Maharjan
 */
@Entity
@Table(name="mst_plant_types")
public class PlantType extends MasterEntity{
    @Column(name = "type_name")
    private String name;
   
    public PlantType()
    {
        
    }

    public PlantType(int id) {
        super(id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
