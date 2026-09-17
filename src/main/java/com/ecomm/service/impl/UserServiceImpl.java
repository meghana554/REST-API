package com.ecomm.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.dto.UserDto;
import com.ecomm.entity.User;
import com.ecomm.repository.UserRepo;
import com.ecomm.requset.LoginRequest;
import com.ecomm.requset.RegisterRequset;
import com.ecomm.service.UserService;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private UserRepo urepo;
	
	
	private final ModelMapper mapper;
	
	public UserServiceImpl(ModelMapper mapper) {
		this.mapper=mapper;
	}

	@Override
	public UserDto register(RegisterRequset request) {
		
		User alreadyExist=urepo.findByEmail(request.getEmail()).orElse(null);
		if(alreadyExist!=null) {
			throw new RuntimeException("user already exist");
		}
		//transfering the data from request to entity
//		User user=new User();
//		user.setName(request.getName());
//		user.setEmail(request.getEmail());
//		user.setPassword(request.getPassword());
//		user.setPhone(request.getPhone());
		User user=mapper.map(request, User.class);
		user=urepo.save(user);
		
		//transfering the data entity to dto :-new user
//		UserDto udto=new UserDto();
//		udto.setUserId(user.getUserId());
//		udto.setName(user.getName());
//		udto.setEmail(user.getEmail());
//		udto.setCreatedAt(user.getCreatedAt());
//		udto.setPhone(user.getPhone());
		UserDto udto=mapper.map(user, UserDto.class);
		return udto;
	}

	@Override
	public UserDto login(LoginRequest request) {
		//email validation
		User alreadyExist=urepo.findByEmail(request.getEmail()).orElseThrow(()->new RuntimeException("user not found"));
		//pass validation
		if(!alreadyExist.getPassword().equals(request.getPassword())) {
			new RuntimeException("password incorrect");
		}
		
		UserDto dto=mapper.map(alreadyExist, UserDto.class);
		return dto;
	}

	@Override
	public UserDto getUserById(Integer userId) {
	     Optional<User> uid=	urepo.findById(userId);
	     
	     if(uid.isPresent()) {
	    	      return mapper.map(uid.get(), UserDto.class);
	     }
	     return null;
	}

	@Override
	public List<UserDto> getAll() {
		List<User>uList=urepo.findAll();
//		if(uList!=null) {
//			System.out.println("not null");
//		}
		List<UserDto> dtoList=uList.stream().map(u->mapper.map(u, UserDto.class)).collect(Collectors.toList());
//		if(dtoList!=null) {
//			System.out.println("dto not null");
//		}
		return dtoList;
	}

}
