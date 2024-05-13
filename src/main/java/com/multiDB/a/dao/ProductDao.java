package com.multiDB.a.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multiDB.a.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, String>{

}
