/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.master.entity;

import com.cibt.web.core.entity.MasterEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Maharjan
 */
@Entity
@Table(name="mst_seasons")
public class Season extends MasterEntity{
    @Column(name = "season_name")
     private String season_name;

    public Season() {
    }

    
    public Season(int id) {
        super(id);
    }

    
    public String getName() {
        return season_name;
    }

    public void setName(String season_name) {
        this.season_name = season_name;
    }
    
}
