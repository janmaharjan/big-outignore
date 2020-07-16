/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.aut.entity;

import com.cibt.web.core.entity.MasterEntity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Maharjan
 */
@Entity
@Table(name="mst_users")
public class User extends MasterEntity{
    @Column(name="username")
    private String userName;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
    @JoinColumn(name="role_id",referencedColumnName="id")
    @ManyToOne
    private Role role;
    @Column(name="created_date", insertable = false,updatable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name="modified_date", insertable= false,updatable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Column(name="status")
    private boolean status;

    public User() {
    }

    
    public User(int id)
    {
        super(id);
    }
    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
    
    
}
