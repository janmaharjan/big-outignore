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
@Table(name="mst_diseases")
public class Disease extends MasterEntity{
    @Column(name = "disease_name")
     private String disease_name;
        @Column(name = "disease_code")
     private String disease_code;

    public Disease() {
    }

    
    public Disease(int id) {
        super(id);
    }

    
    public String getName() {
        return disease_name;
    }

    public void setName(String disease_name) {
        this.disease_name = disease_name;
    }

    public String getDisease_code() {
        return disease_code;
    }

    public void setDisease_code(String disease_code) {
        this.disease_code = disease_code;
    }
    
    
}
