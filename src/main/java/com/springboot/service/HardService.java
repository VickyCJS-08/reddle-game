package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.HardRiddle;
import com.springboot.repositary.HardRepositary;
@Service
public class HardService {
	         @Autowired
              private HardRepositary repo;
	         
	         public List<HardRiddle> getAllRiddle(){
	        	 return repo.findAll();
	         }
	         public HardRiddle getById(Long id) {
	        	 return repo.findById(id).orElse(null);
	         } 
}
