package sport.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sport.entity.Hobby;
import sport.util.DBConnection;

public class HobbyDao {
	public HobbyDao() {

	}

	public Hobby getHobbyByHobid(int hobid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		Hobby hobby = new Hobby();
		String sql = "select * from hobby where hobid=" + hobid;

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if (rs.next()) {
				hobby.setHobid(hobid);
				hobby.setName(rs.getString(2));
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
		return hobby;
	}

	public int getHobidByName(String hobby) {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		int hobid = 0;
		String sql = "select hobid from hobby where name='" + hobby + "'";

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if (rs.next()) {
				hobid = rs.getInt(1);
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

		return hobid;
	}

	public List<Hobby> getAllHobbies() {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		List<Hobby> hobbies = new ArrayList<Hobby>();
		String sql = "select * from hobby";

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				Hobby hobby = new Hobby();
				hobby.setHobid(rs.getInt(1));
				hobby.setName(rs.getString(2));
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
}
