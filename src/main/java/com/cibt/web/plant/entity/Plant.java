/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.plant.entity;

import com.cibt.web.core.entity.MasterEntity;
import com.cibt.web.master.entity.Disease;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author Maharjan
 */
@Entity
@Table(name = "mst_plants")
public class Plant extends MasterEntity {
    @Column(name="plant_name")
    private String name;
    @Column(name="plant_description")
    private String description;
    @Column(name="seed_image")
    private String seedImage;
    @Column(name="plant_image")
    private String plantImage;
    @JoinColumn(name="plant_type_id",referencedColumnName="id")
    @ManyToOne
    private PlantType plantType;
    @Column(name="created_date",insertable = false, updatable= false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name="modified_date",nullable=true)
    private Date modifiedDate;
    @Column(name="status")
    private boolean status;
    @ManyToMany
    @JoinTable(name="tbl_plant_diseases",
    joinColumns={@JoinColumn(name="plant_id")},
    inverseJoinColumns = {@JoinColumn(name="disease_id")})
    private List<Disease> diseases;

    public Plant() {
    }
    public Plant(int id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeedImage() {
        return seedImage;
    }

    public void setSeedImage(String seedImage) {
        this.seedImage = seedImage;
    }

    public String getPlantImage() {
        return plantImage;
    }

    public void setPlantImage(String plantImage) {
        this.plantImage = plantImage;
    }

    public PlantType getPlantType() {
        return plantType;
    }

    public void setPlantType(PlantType plantType) {
        this.plantType = plantType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }
    
    
    
}
