package sport.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sport.entity.Hobby;
import sport.service.HobbyService;
import sport.service.UserHobbyService;
import sport.util.DBConnection;

public class UserHobbyDao {
	public UserHobbyDao() {

	}

	public List<Hobby> getAllHobbiesByUid(int uid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		List<Hobby> hobbies = new ArrayList<Hobby>();
		String sql = "select hobid from user_hobby where uid=" + uid;

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				Hobby hobby = new HobbyService().getHobbyByHobid(rs.getInt(1));
				hobbies.add(hobby);
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

		return hobbies;
	}

	public boolean updateHobbiesByUid(int uid, List<String> hobbies) {
		// TODO Auto-generated method stub
		HobbyService hobbyService = new HobbyService();
		UserHobbyService userHobbyService = new UserHobbyService();
		int hobid = 0;

		userHobbyService.deleteAllHobbiesByUid(uid);

		for (String hobby : hobbies) {
			hobid = hobbyService.getHobidByName(hobby);
			userHobbyService.addHobbyByUid(uid, hobid);
		}

		return true;
	}

	public void deleteAllHobbiesByUid(int uid) {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		String sql = "delete from user_hobby where uid=" + uid;

		try {
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
	}

	public void addHobbyByUid(int uid, int hobid) {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		String sql = "insert into user_hobby(uid,hobid) values(" + uid + ","
				+ hobid + ")";

		try {
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
	}
}
