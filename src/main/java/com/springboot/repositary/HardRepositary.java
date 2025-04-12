package com.springboot.repositary;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.HardRiddle;
@Repository
public interface HardRepositary extends JpaRepository<HardRiddle, Long> {

}
