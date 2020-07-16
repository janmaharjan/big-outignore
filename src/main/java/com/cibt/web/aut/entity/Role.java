/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.aut.entity;

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
@Table(name="mst_roles")
public class Role extends MasterEntity{
    @Column(name = "role_name")
    private String name;
    @OneToMany(mappedBy = "role")
    private List<User> users;

    public Role() {
    }
    
    
    public Role(int id) {
        super(id);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
     
}
