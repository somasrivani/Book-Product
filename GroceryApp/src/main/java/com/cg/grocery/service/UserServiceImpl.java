package com.cg.grocery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.grocery.entities.UserEntity;
import com.cg.grocery.exception.DuplicateRecordException;
import com.cg.grocery.repository.UserDAOInt;

@Service
public class UserServiceImpl implements UserServiceInt {
	@Autowired
	private UserDAOInt udao;
	
	public long add(UserEntity u) throws DuplicateRecordException{
		udao.saveAndFlush(u);
		return 0;
		
	}
	public void delete(long id) {
		udao.deleteById(id);
	}
	
	public UserEntity findByLogin(String login) {
		return udao.findByLogin(login);
	}
	public void update(UserEntity u) throws DuplicateRecordException{
		udao.saveAndFlush(u);
	}
	
	public List<UserEntity> getAllUser() {
		return udao.findAll();
	}
	
	public boolean changePassword(Long id, String oldPass, String newPass) {
		boolean status = false;
		Optional<UserEntity> u = udao.findById(id);
		UserEntity user = u.get();
		if(user.getPassword().equals(oldPass)) {
			user.setPassword(newPass);
			udao.saveAndFlush(user);
			status = true;
			}
		return status;
	}
//	public List<UserEntity> search(UserEntity u){
//		udao.findByLogin(u.getLoginId());
//		
//	}
	
}
