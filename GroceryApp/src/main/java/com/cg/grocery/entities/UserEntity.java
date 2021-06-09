package com.cg.grocery.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name= "user_database")
public class UserEntity extends BaseEntity {
	
	@Size(min=0,max=20,message="First name should be between 1 and 20 chars")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message = "Last name can not be blank")
	@Size(min=1,max=20,message="Last name should be between 1 and 20 chars")
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank(message = "login id can not be blank")
	@Size(min=1,max=20,message="First name should be between 4 and 10 chars")
	@Column(name="login")
	private String loginId;
	
	@NotBlank(message = "Password can not be blank")
	@Size(min=1,max=20,message="Password should be between 8 and 24 chars")
	private String password;

	
	@NotBlank(message = "Mobile number can not be blank")
	@Size(min=1,max=20,message="Mobile number should be 10 char")
	@Column(name="mobile_no")
	private String mobileNo;
	
	@Email
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="role_id")
	private long roleId;
	
	public long getId() {
		return super.id;
	}
	
	public void setId(long id) {
		super.id= id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	
	
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return firstName+" "+lastName;
	}

}
