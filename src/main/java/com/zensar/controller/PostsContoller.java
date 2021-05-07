package com.zensar.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.Model.Posts;
import com.zensar.service.PostsService;

@RestController
public class PostsContoller {

	
	@Autowired
	private PostsService service;
	
	
	@GetMapping("/count")
	public Integer getall()
	{
		return service.count();
	}
	
	@PutMapping("/update/{id}")
	public Posts update(@PathVariable (value ="id") long id , 
			@RequestBody Posts postsD)
	{
		Posts update=service.savedata(postsD, id);	
		return update;
	}
	
}
