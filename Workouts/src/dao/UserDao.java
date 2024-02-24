package dao;

import java.util.Collection;

public abstract class UserDao { // Data Access Object
	public abstract UserDTO findUserByPrimaryKey(int uid);
	public abstract Collection<UserDTO> findAll();
	public abstract UserDTO findByName(String uname);
	public abstract void insertUser(UserDTO user);
	public abstract void updateUser(UserDTO user);
	public abstract void deleteUser(int userid);
	public abstract void deleteUserByName(String uname);
}
