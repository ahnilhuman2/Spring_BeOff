package com.lec.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.User;

public interface RegionRepository extends JpaRepository<Region, Long> {

}
