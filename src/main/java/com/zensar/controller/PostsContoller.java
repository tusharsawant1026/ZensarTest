package com.zensar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.Model.Posts;
import com.zensar.service.PostsService;

@RestController
public class PostsContoller {

	
	@Autowired
	private PostsService service;

	
	//count of the number of unique user Ids 
	
	@GetMapping("/Count")
	public Integer getall()
	{
		return service.count();
	}
	
   //Return unique user ids in array list

	@GetMapping("/unique")
	public List<Long> unique()
	{
		return service.unique();
	}
	
   //Updated User List endpoint and also Return the modified JSON object
	
	@PutMapping("/update/{id}")
	public Posts update(@PathVariable (value ="id") long id , 
			@RequestBody Posts postsD)
	{
		Posts update=service.savedata(postsD, id);	
		return update;
	}
	
}
