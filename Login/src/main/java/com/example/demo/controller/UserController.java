package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.Iuser.IUser;
import com.example.demo.entity.User;

@Controller
public class UserController {
	
	@Autowired
	public IUser service;

	@GetMapping("/empleado")
	public String listar(Model model)
	{
		List<User>usuarios=service.listar();
		model.addAttribute("usuarios", usuarios);
		System.out.print(usuarios.size());
		return "empleados";
	}
	
	@GetMapping("/new")
	public String agregar(Model model)
	{
		model.addAttribute("user", new User());
		return "agregar";
	}
	
	
	
	@PostMapping("/save")
	public String save(@Valid User u, Model model )
	{
		service.save(u);
		return "redirect:/empleado";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model)
	{
		Optional<User>user=service.listarId(id);
		model.addAttribute("usuario", user);
		return "agregar";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable Long id, Model model)
	{
		service.delete(id);
		return "redirect:/empleado";
	}
}
