package com.multiDB.a.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiDB.a.entity.IisiUser;

public interface IisiUserRepository extends JpaRepository<IisiUser, Long>{
    // 根据用户名查询会员信息
	IisiUser findByUserName(String userName);
}
