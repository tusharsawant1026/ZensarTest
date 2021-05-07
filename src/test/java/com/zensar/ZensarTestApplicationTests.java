package com.zensar;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zensar.Model.Posts;
import com.zensar.controller.PostsContoller;
import com.zensar.service.PostsService;

@RunWith(SpringRunner.class)
@SpringBootTest
class ZensarTestApplicationTests {

	@Test
	void contextLoads() {
	}
	

	@InjectMocks
	private PostsContoller postsContoller;
	
	@Mock
	private PostsService postsService;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
    public void getCountTest()
    {
        List<Posts> list = new ArrayList<Posts>();
        Posts One = new Posts(1, 1, "abc", "i love java");
        Posts Two = new Posts(1,2 , "kolenchiski", "alexk@yahoo.com");
        Posts Three = new Posts(2, 3, "Waugh", "swaugh@gmail.com");
         
        list.add(One);
        list.add(Two);
        list.add(Three);
        

		Map<Long, List<Posts>> map	= list.stream()
				.collect(Collectors.groupingBy(Posts::getUserId));
	
        int cout=map.size();
        
    	when(postsService.count()).thenReturn(cout);
        
       int i= postsContoller.getall();
      
        assertEquals(2, cout);
        verify(postsService, times(1)).count();
    }
	
	@Test
	public void updateTest()
	{	
		Posts p=postsService.getById(3);
		p.setTitle("1800Flowers");
		p.setBody("1800Flowers");
		
		postsService.savedata(p,3);
		 assertEquals("test", p.getTitle());
         assertEquals("test", p.getBody());
	
	}
	
}
