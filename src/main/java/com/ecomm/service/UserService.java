package com.ecomm.service;

import java.util.List;

import com.ecomm.dto.UserDto;
import com.ecomm.requset.LoginRequest;
import com.ecomm.requset.RegisterRequset;

public interface UserService {
	
	public UserDto register(RegisterRequset request);
	
	public UserDto login (LoginRequest request);
	
	public UserDto getUserById(Integer userId);
	
	public List<UserDto> getAll();
	
	

}
