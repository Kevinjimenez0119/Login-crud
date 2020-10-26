package com.example.demo.Iuser;

import java.util.List;
import java.util.Optional;



import com.example.demo.entity.User;


public interface IUser {
	
	public List<User>listar();
    public Optional<User>listarId(Long id);
    public int save(User u);
    public void delete(Long id);

}
