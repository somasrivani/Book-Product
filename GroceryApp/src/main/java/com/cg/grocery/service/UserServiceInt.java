package com.cg.grocery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.grocery.entities.UserEntity;
import com.cg.grocery.exception.DuplicateRecordException;

@Service
public interface UserServiceInt {

	public long add(UserEntity bean) throws DuplicateRecordException;
	
	public void delete(long id) ;
	
	public void update(UserEntity bean) throws DuplicateRecordException;
	
	//public UserEntity findByPK(long pk) ;
	
	public UserEntity findByLogin(String login) ;
	
//	public List<UserEntity> search(UserEntity bean);
//	
//	public List search(UserEntity bean, int pageNo, int pageSize) ;
//	 
    public boolean changePassword(Long id, String oldPassword,String newPassword);
//    
//    public UserEntity authenticate(UserEntity bean);
//
//    public long registerUser(UserEntity bean) throws DuplicateRecordException  ;
//    
//    public boolean forgetPassword(String login);
	
}
