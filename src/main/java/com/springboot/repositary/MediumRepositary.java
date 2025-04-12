package com.springboot.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.MediumRiddle;
@Repository
public interface MediumRepositary extends JpaRepository<MediumRiddle, Long> {

}
