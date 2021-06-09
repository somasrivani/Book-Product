package com.cg.grocery.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.grocery.entities.UserEntity;
import com.cg.grocery.service.UserServiceImpl;
import com.cg.grocery.service.UserServiceInt;

@RestController
@RequestMapping("/user")
public class UserServiceControl {
	
	@Autowired
	private UserServiceImpl userv;
	
	
	@PostMapping("/add")
	public ResponseEntity<String> addUser(
				@RequestBody UserEntity u){
			try {
			userv.add(u);
			}
			catch(Exception e) {
				
			}
			return new ResponseEntity<String>("User added", HttpStatus.OK);				
     	}
	
	@GetMapping("/alluser")
	public ResponseEntity<List<UserEntity>> getAllUser(){
		List<UserEntity> ul= userv.getAllUser();
		if(ul.isEmpty()) {
			return new ResponseEntity("Sorry No Data", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<UserEntity>>(ul, HttpStatus.OK);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteUser(
			@RequestBody UserEntity u){
		long tempId=u.getId();
		userv.delete(tempId);
		
		return new ResponseEntity<String>("User Deleted", HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateTrainee(
			@RequestBody UserEntity u){
			try {
			userv.update(u);
			}
			catch(Exception e) {
			}
		return new ResponseEntity<String>("User updated", HttpStatus.OK);
	}
	
	@GetMapping("/bylogin/{login}")
	public ResponseEntity<UserEntity> findByLogin(
			@PathVariable("login")String login){
		UserEntity u= userv.findByLogin(login);
		if(u==null) {
			return new ResponseEntity("No such user found", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<UserEntity>(u, HttpStatus.OK);
	}
	@PutMapping("/changepassword")
	public ResponseEntity<String> changePassword(
			@PathVariable Long id, String oldPass, String newPass){
		boolean status= userv.changePassword(id, oldPass, newPass);
		if(status) {
			return new ResponseEntity<String> ("Password Changed Succesfully", HttpStatus.OK);
		}
		return new ResponseEntity<String> ("Error", HttpStatus.OK);
	}

}