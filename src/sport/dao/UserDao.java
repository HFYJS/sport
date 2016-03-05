package sport.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sport.entity.User;
import sport.service.UserService;
import sport.util.DBConnection;

public class UserDao {

	public UserDao() {

	}

	public int getUidByName(String name) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		int uid = -1;
		String sql = "select uid from user where name='" + name + "'";

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if (rs.next()) {
				uid = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uid;
	}

	// 查不到返回null
	public User getUserByName(String name) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		User user = null;
		String sql = "select * from user where name='" + name + "'";

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if (rs.next()) {
				user = new User();
				user.setUid(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setSex(rs.getString(4));
				user.setAge(rs.getInt(5));
				user.setTel(rs.getString(6));
				user.setRace(rs.getString(7));
				user.setNati(rs.getString(8));
				user.setHeadPath(rs.getString(9));
				user.setBackPath(rs.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != stat) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBConnection.close(conn);
		}
		return user;
	}

	public User getUserByUid(int uid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		User user = null;
		String sql = "select * from user where uid=" + uid;

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if (rs.next()) {
				user = new User();
				user.setUid(uid);
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setSex(rs.getString(4));
				user.setAge(rs.getInt(5));
				user.setTel(rs.getString(6));
				user.setRace(rs.getString(7));
				user.setNati(rs.getString(8));
				user.setHeadPath(rs.getString(9));
				user.setBackPath(rs.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public List<User> getAllUsers() {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		String sql = "select uid from user order by uid";

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				User user = new UserService().getUserByUid(rs.getInt(1));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (null != stat) {
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			DBConnection.close(conn);
		}

		return users;
	}
}
