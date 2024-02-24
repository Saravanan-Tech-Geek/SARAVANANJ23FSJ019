package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class UserDaoImpl extends UserDao {
	Connection conn;

	public UserDaoImpl() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/javabatch", "root", "Gaayathri@123");
		
	}

	@Override
	public UserDTO findUserByPrimaryKey(int uid) {
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from users where userid = ?");
			stmt.setInt(1, uid);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				UserDTO userObj = new UserDTO();
				userObj.setUid(rs.getInt(1));
				userObj.setUname(rs.getString(2));
				userObj.setUpass(rs.getString(3));
				userObj.setSalary(rs.getInt(4));
				userObj.setFlag(rs.getInt(5));
				return userObj;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Collection<UserDTO> findAll() {
		Statement stmt;
		ArrayList<UserDTO> users = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");

			while (rs.next()) {
				UserDTO userObj = new UserDTO();
				userObj.setUid(rs.getInt(1));
				userObj.setUname(rs.getString(2));
				userObj.setUpass(rs.getString(3));
				userObj.setSalary(rs.getInt(4));
				userObj.setFlag(rs.getInt(5));
				users.add(userObj);
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public UserDTO findByName(String uname) {
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from users where username = ?");
			stmt.setString(1, uname);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				UserDTO userObj = new UserDTO();
				userObj.setUid(rs.getInt(1));
				userObj.setUname(rs.getString(2));
				userObj.setUpass(rs.getString(3));
				userObj.setSalary(rs.getInt(4));
				userObj.setFlag(rs.getInt(5));
				return userObj;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void insertUser(UserDTO user) {
		try {
			String sql = "INSERT INTO users (userid, username, password,salary,flag) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, user.getUid());
			stmt.setString(2, user.getUname());
			stmt.setString(3, user.getUpass());
			stmt.setInt(4, user.getSalary());
			stmt.setInt(5, user.getFlag());

			int rows = stmt.executeUpdate();

			System.out.println("Rows inserted: " + rows);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void updateUser(UserDTO user) {

		try {
			String sql = "UPDATE users SET username = ?, password = ?, salary = ?, flag = ? WHERE userid = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, user.getUname());
			stmt.setString(2, user.getUpass());
			stmt.setInt(3, user.getSalary());
			stmt.setInt(4, user.getFlag());
			stmt.setInt(5, user.getUid());

			int rows = stmt.executeUpdate();

			System.out.println("Rows inserted: " + rows);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void deleteUser(int userid) {
		try {
			String sql = "DELETE FROM users WHERE userid = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1,userid);

			int rows = stmt.executeUpdate();

			System.out.println("Rows inserted: " + rows);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteUserByName(String uname) {
		try {
			String sql = "DELETE FROM users WHERE username = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1,uname);

			int rows = stmt.executeUpdate();

			System.out.println("Rows inserted: " + rows);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
