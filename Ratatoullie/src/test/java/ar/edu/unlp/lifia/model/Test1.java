package ar.edu.unlp.lifia.model;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.unlp.lifia.model.Location;
import ar.edu.unlp.lifia.model.User;

public class Test1 {

	User user1;
	User user2;
	User user3;
	User user4;
	
	@Before
	public void before(){
		user1= new User("User1", new Location(2, 3));
		user2= new User("User3", new Location(2, 3));
		user3= new User("User3", new Location(2, 3));
		user4= new User("User4", new Location(2, 3));
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
	public void testGetFollowings(){
		user1.follow(user2);
		user1.follow(user3);
		user1.follow(user4);
		Assert.assertTrue(user1.getFollowings().contains(user2));
		Assert.assertTrue(user1.getFollowers().contains(user3));
		Assert.assertTrue(user1.getFollowers().contains(user4));
		
	}
	
	@Test
	public void testRecommend(){
		UserResponsible resUser = new UserResponsible("resUser", new Location(2, 3));
		Restaurant r = new Restaurant("FastFood", 07062017, new Location(2, 3), resUser);
		Menu m = new Menu(r, "Locro", 07062017);
		user1.recommend(m, user2, "Bueno", 07062017);
		Assert.assertFalse(user2.getRecommendations().isEmpty());
	}
	
	@Test
	public void testRecommendFollowers(){
		UserResponsible resUser = new UserResponsible("resUser", new Location(2, 3));
		Restaurant r = new Restaurant("FastFood", 07062017, new Location(2, 3), resUser);
		Menu m = new Menu(r, "Locro", 07062017);
		user2.follow(user1);
		user3.follow(user1);
		user4.follow(user1);
		user1.recommendFollowers(m, "Bueno", 07062017);
		Assert.assertFalse(user2.getRecommendations().isEmpty());
		Assert.assertFalse(user3.getRecommendations().isEmpty());
		Assert.assertFalse(user4.getRecommendations().isEmpty());
	}
	
	@Test
	public void testUserComment(){
		Vote v = Vote.POSITIVE;
		UserResponsible resUser = new UserResponsible("resUser", new Location(2, 3));
		Restaurant r = new Restaurant("FastFood", 07062017, new Location(2, 3), resUser);
		Menu m = new Menu(r, "Locro", 07062017);
		Comment c = new Comment(user1, "Malo", 01032017, m, v);
		user1.comment(c);
		Assert.assertFalse(m.getComments().isEmpty());
	}
}
