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
		user1= new User("User1", new Location(2, 3));
		user2= new User("User3", new Location(2, 3));
	}
	
	@Test
	public void userFollow(){		
		user1.follow(user2);
		Assert.assertTrue(user1.getFollowings().contains(user2));
		Assert.assertTrue(user2.getFollowers().contains(user1));
	}
	
	@Test
	public void userStopFollowing(){
		//added
		user1.follow(user2);
		user1.stopFollowing(user2);
		Assert.assertFalse(user1.getFollowings().contains(user2));
		Assert.assertFalse(user2.getFollowers().contains(user1));
	}
	
	@Test
	public void testRecommend(){
		UserResponsible resUser = new UserResponsible("resUser", new Location(2, 3));
		Restaurant r = new Restaurant("FastFood", 07062017, new Location(2, 3), resUser);
		Menu m = new Menu(r, "Locro", 07062017);
		user1.recommend(m, user2, "Bueno", 07062017);
		Assert.assertFalse(user2.getRecommendations().isEmpty());
	}
}
