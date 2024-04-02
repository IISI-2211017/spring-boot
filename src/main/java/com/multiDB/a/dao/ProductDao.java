package com.multiDB.a.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multiDB.a.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, String>{

}
