//package com.jpa.repository.impl;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//
//import com.example.model.Aaa;
//import com.genericDao.Impl.GenericDaoImpl;
//import com.jpa.repository.TestRepository;
//
//import jakarta.persistence.EntityManager;
//
//public class TestRepositoryImpl extends GenericDaoImpl<Aaa> implements TestRepository{
//
//	public TestRepositoryImpl(Class<Aaa> domainClass, EntityManager entityManager) {
//		super(domainClass, entityManager);
//	}
//	
//}
////