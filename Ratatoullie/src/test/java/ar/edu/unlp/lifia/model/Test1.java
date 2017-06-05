package ar.edu.unlp.lifia.model;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.unlp.lifia.model.Location;
import ar.edu.unlp.lifia.model.User;



public class Test1 {

	User user1;
	User user2;
	
	@Before
	public void before(){
		user1= new User("User1", new Location("2", "3"));
		user2= new User("User3", new Location("2", "3"));
	}
	@Test
	public void userFollow(){		
		user1.follow(user2);
		Assert.assertTrue(user1.getFollowings().contains(user2));
		Assert.assertTrue(user2.getFollowers().contains(user1));
	}
}
