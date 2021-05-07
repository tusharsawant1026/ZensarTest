package com.zensar.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.el.stream.Stream;
import com.zensar.Model.Posts;

@org.springframework.stereotype.Service
public class PostsService  {

	private static Posts[] posts;
	
	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public void getalldata()
	{
		 ResponseEntity<Posts[]> responseEntity = 
	        	    restTemplate.getForEntity("http://jsonplaceholder.typicode.com/posts",Posts[].class); 
		
		  Posts[] postArray = responseEntity.getBody();
	
		  posts=postArray;
	}
	    

	public Posts getById(long id)
	{
	 	 	return	Arrays.stream(posts)
				  .filter(post -> id==(post.getId()))
				  .findFirst().get();
	}
	
	
	
	public Integer count()
	{
			Map<Long, List<Posts>> map	=  Arrays.stream(posts)
					.collect(Collectors.groupingBy(Posts::getUserId));	
			return map.size();	
	}
	
	public Posts savedata(Posts post, long id )
	{
		Posts p=new Posts();
		p.setUserId(post.getUserId());
		p.setId(post.getId());
		p.setTitle(post.getTitle());
		p.setBody(post.getBody());
		
		Arrays.asList(posts).add((int) getById(id).getId(), p);	
	    return p;
	}


	public List<Long> unique() {
		// TODO Auto-generated method stub
		Map<Long, List<Posts>> map	=  Arrays.stream(posts)
				.collect(Collectors.groupingBy(Posts::getUserId));
	     
	     ArrayList<Long> keyList = new ArrayList<Long>(map.keySet());
	     
		 return keyList;
	}
	
}
