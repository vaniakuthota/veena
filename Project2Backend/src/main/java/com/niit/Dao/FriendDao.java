package com.niit.Dao;
import java.util.List;

import com.niit.Models.*;
public interface FriendDao {
List<User> getAllSuggestedUsers(String email);
	void addFriendRequest(Friend friend);
	List<Friend> getPendingRequests(String email);

	void acceptRequest(Friend friendRequest);

	void deleteRequest(Friend friendRequest);

	List<User>  listOfFriends(String email);
}
