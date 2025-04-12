package com.springboot.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.springboot.entity.Riddle;
import com.springboot.repositary.RiddleRepositary;
@Service
public class RiddleSerivice {
	@Autowired
	private RiddleRepositary repo;

	//select
	public List<Riddle> getAll(){
		return repo.findAll();
	}
	//selectById
	public Riddle getById(Long id) {
		return  repo.findById(id).orElse(null);
	}
}
