package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Aaa;

@Repository
public interface TestRepository extends JpaRepository<Aaa, String>{
	
}
