package com.zensar.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.el.stream.Stream;
import com.zensar.Model.Posts;

@org.springframework.stereotype.Service
public class PostsService implements CommandLineRunner {

	private static List<Posts> posts;
	
	@Override
	public void run(String... args) throws Exception {
	
		
       ObjectMapper objectMapper = new ObjectMapper();

            posts =  objectMapper.readValue(new File("src/main/resources/posts.json"),
            		new TypeReference<List<Posts>>() {}
            		);	
	}
	
	public Posts getById(long id)
	{
	 	 	return	posts.stream()
				  .filter(post -> id==(post.getId()))
				  .findFirst().get();
	}
	
	
	
	public Integer count()
	{
			List<Posts> list=posts;
		
			Map<Long, List<Posts>> map	= list.stream()
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
	    Posts update=	posts.set((int) getById(id).getId(), p);
	    return update;
	}
	


}
