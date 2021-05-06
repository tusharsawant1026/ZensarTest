package com.zensar.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.Spring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.zensar.Model.Posts;
import com.zensar.controller.PostsContoller;
import com.zensar.service.PostsService;

@SpringBootTest
public class PostTest {

	
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
      
        assertEquals(4, cout);
        verify(postsService, times(1)).count();
    }
	
	@Test
	public void updateTest()
	{
		when(postsService.getById(1)).thenReturn(new Posts(1, 1, "test", "test"));
		Posts test=new Posts();
		 Posts post = postsContoller.update(1,test);
         
	        assertEquals("Lokesh", post.getTitle());
	        assertEquals("Gupta", post.getBody());
		
	}
	
	
	
	
}
