package com.cg.grocery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.grocery.entities.UserEntity;

@Repository("udao")
public interface UserDAOInt extends JpaRepository<UserEntity,Long> {
	
//	public long add(UserEntity bean);
//	
//	public void update(UserEntity bean);
//	
//	public void delete(UserEntity bean);
	
	@Query("SELECT u FROM UserEntity u  WHERE u.loginId like :lg")
	public UserEntity findByLogin(@Param("lg") String login);
	
//	public UserEntity findByPk(long id);
//	
//	public List<UserEntity> search(UserEntity bean, long pageNo, int pageSize);
//	
//	public List<UserEntity> search(UserEntity bean);
//	
//	public UserEntity authenticate(UserEntity bean);
	
}
