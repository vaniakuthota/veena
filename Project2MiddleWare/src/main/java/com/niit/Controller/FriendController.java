package com.niit.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.Dao.FriendDao;
import com.niit.Dao.UserDao;
import com.niit.Models.BlogComment;
import com.niit.Models.ErrorClazz;
import com.niit.Models.Friend;
import com.niit.Models.User;

@Controller
public class FriendController {
	@Autowired
	private FriendDao friendDao;
	@Autowired
	private UserDao userDao;
	@RequestMapping(value="/suggestedusers",method=RequestMethod.GET)
	public ResponseEntity<?> getAllSuggestedUsers(HttpSession session){
		String email=(String)session.getAttribute("email");
		if(email==null){
			ErrorClazz errorClazz=new ErrorClazz(5,"Unauthorized access.. please login");
			return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
		}
		List<User> suggestedUsers=friendDao.getAllSuggestedUsers(email);
		return new ResponseEntity<List<User>>(suggestedUsers,HttpStatus.OK);
	}
	@RequestMapping(value="/friendrequest",method=RequestMethod.POST)
	public ResponseEntity<?> friendRequest(@RequestBody User toId   ,HttpSession session){
		String email=(String)session.getAttribute("email");
		//Get the email of the logged in user
		if(email==null){
			ErrorClazz errorClazz=new ErrorClazz(5,"Unauthorized access.. please login");
			return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
		}
		User fromId=userDao.getUser(email);
Friend friend=new Friend();
friend.setStatus('p');
friend.setFromId(fromId);
friend.setToId(toId);
friendDao.addFriendRequest(friend);

return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	
	}
	@RequestMapping(value="/pendingrequests",method=RequestMethod.GET)
	public ResponseEntity<?> pendingRequests(HttpSession session){
		String email=(String)session.getAttribute("email");
		//Get the email of the logged in user
		if(email==null){
			ErrorClazz errorClazz=new ErrorClazz(5,"Unauthorized access.. please login");
			return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
		}

		List<Friend> pendingRequests=friendDao.getPendingRequests(email);
		return new ResponseEntity<List<Friend>>(pendingRequests,HttpStatus.OK);
	}
	@RequestMapping(value="/acceptrequest",method=RequestMethod.PUT)
	public ResponseEntity<?> acceptRequest(@RequestBody Friend friendRequest,HttpSession session){
		String email=(String)session.getAttribute("email");
		//Get the email of the logged in user
		if(email==null){
			ErrorClazz errorClazz=new ErrorClazz(5,"Unauthorized access.. please login");
			return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
		}
		friendDao.acceptRequest(friendRequest);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	@RequestMapping(value="/deleterequest",method=RequestMethod.PUT)
	public ResponseEntity<?> deleteRequest(@RequestBody Friend friendRequest,HttpSession session){
		String email=(String)session.getAttribute("email");
		//Get the email of the logged in user
		if(email==null){
			ErrorClazz errorClazz=new ErrorClazz(5,"Unauthorized access.. please login");
			return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
		}
		friendDao.deleteRequest(friendRequest);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@RequestMapping(value="/friends",method=RequestMethod.GET)
	public ResponseEntity<?> listOfFriends(HttpSession session){
		String email=(String)session.getAttribute("email");
		//Get the email of the logged in user
		if(email==null){
			ErrorClazz errorClazz=new ErrorClazz(5,"Unauthorized access.. please login");
			return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
		}
		List<User> friends=friendDao.listOfFriends(email);
		return new ResponseEntity<List<User>>(friends,HttpStatus.OK);
	}
	}




		
		


