package com.dao;

import java.util.ArrayList;
import com.model.UserDetails;

public interface UserDetailsDAO {
	public int saveUserDetails(UserDetails details);

	public int updateUserDetails(UserDetails details);
	
	public int removeUserDetails(int id);
	public int deactivateUser(int id);

	public ArrayList<UserDetails> getUserDetailsList();

	public UserDetails findUserById(int id);
	public UserDetails findUserByName(String name);

	public boolean checkUserCreds(String userid, String password);

	public int saveUserCreds(String userID, String password);

	public int getTotalUsers();
}
