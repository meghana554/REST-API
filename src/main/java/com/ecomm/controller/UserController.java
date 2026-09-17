package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.dto.UserDto;
import com.ecomm.requset.LoginRequest;
import com.ecomm.requset.RegisterRequset;
import com.ecomm.service.UserService;

@RestController  //-->combination of (controller + responsebody)
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService uservice;
	
	@PostMapping("/register")
	public ResponseEntity<?>register(@RequestBody RegisterRequset request){
		UserDto udto=uservice.register(request);
		return ResponseEntity.ok(udto);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?>login(@RequestBody LoginRequest request){
		UserDto dto=uservice.login(request);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/id")
	public ResponseEntity<?> getUserById(Integer userId){
		UserDto dto=uservice.getUserById(userId);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping("/getAll")
	public ResponseEntity<?> getAll(){
		List<UserDto> dtoList=uservice.getAll();
		return ResponseEntity.ok(dtoList);
	}

}
