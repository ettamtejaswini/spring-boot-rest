package com.spring.rest.web.services.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	
	private static int userCount = 0;
	
	static {
		users.add(new User(++userCount,"Adam", LocalDate.now().minusYears(32)));
		users.add(new User(++userCount, "Eva", LocalDate.now().minusYears(30)));
		users.add(new User(++userCount, "Jim", LocalDate.now().minusYears(25)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(int id) {
//		return users.stream()
//				.filter(user -> user.getId() == id)
//				.findFirst()
//				.get();
		
		return users.stream()
				.filter(user -> user.getId() == id)
				.findFirst().orElse(null);
	}
	
	public User saveUser(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	
	public void deleteById(int id) {
		users.removeIf(user -> user.getId().equals(id));
	}
}
