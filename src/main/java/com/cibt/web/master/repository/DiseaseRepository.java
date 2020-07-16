/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.master.repository;

import com.cibt.web.master.entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Maharjan
 */
@Repository
public interface DiseaseRepository extends JpaRepository<Disease,Integer>{
    
}
