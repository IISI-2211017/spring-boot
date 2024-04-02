//package com.genericDao.Impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.support.JpaEntityInformation;
//import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
//
//import com.genericDao.GenericDao;
//
//import jakarta.persistence.EntityManager;
//
//public class GenericDaoImpl<T> extends SimpleJpaRepository<T, String> implements GenericDao<T> {
//
//    public GenericDaoImpl(Class<T> domainClass, EntityManager entityManager) {
//        super(domainClass, entityManager);
//    }
//}
