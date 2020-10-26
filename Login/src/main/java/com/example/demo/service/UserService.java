package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Iuser.IUser;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService implements IUser{

	@Autowired
	private UserRepository data;
	@Override
	public List<User> listar() {
		// TODO Auto-generated method stub
		return (List<User>)data.findAll();
	}

	@Override
	public Optional<User> listarId(Long id) {
		
		return data.findById(id);
	}

	@Override
	public int save(User u) {
		int res=0;
		User user=data.save(u);
		if(!user.equals(null))
		{
			res=1;
		}
		return res;
	}

	@Override
	public void delete(Long id) {
		data.deleteById(id);
		
	}

	
	
	

}
