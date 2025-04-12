package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.MediumRiddle;

import com.springboot.repositary.MediumRepositary;

@Service
public class MidiumService {
	      @Autowired
          private MediumRepositary repo;
          
          public List<MediumRiddle> getAllRiddle(){
        	  return repo.findAll();
          } 
          
          public MediumRiddle getRiddleById(Long id) {
        	  return repo.findById(id).orElse(null);
          } 
}
