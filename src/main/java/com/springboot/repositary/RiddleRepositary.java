package com.springboot.repositary;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Riddle;


@Repository
public interface RiddleRepositary extends JpaRepository<Riddle, Long> {
	 
}
