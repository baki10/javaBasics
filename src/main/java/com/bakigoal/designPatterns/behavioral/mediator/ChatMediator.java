package com.bakigoal.designPatterns.behavioral.mediator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilmir on 24.06.16.
 */
public class ChatMediator {

	private static DateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY HH:mm");

	private List<User> users;

	public ChatMediator() {
		this.users = new ArrayList<>();
	}

	public void addUser(User user) {
		users.add(user);
	}

	public void removeUser(User user){
		if(users.contains(user)){
			users.remove(user);
			System.out.println("!!!" + user.getName() + " has left chat!!!");
		}
	}

	public void sendMessage(User user, String msg) {
		for (User u : users) {
			if (u != user) {
				u.receiveMessage(msg);
			}
		}
	}
}
