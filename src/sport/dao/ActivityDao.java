package sport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sport.entity.Activity;
import sport.util.DBConnection;

public class ActivityDao {
	public ActivityDao() {

	}

	public List<Activity> search() {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		List<Activity> activities = new ArrayList<Activity>();
		String sql = "select * from activity order by actid";

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				Activity activity = new Activity();
				activity.setActid(rs.getInt(1));
				activity.setName(rs.getString(2));
				activities.add(activity);
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

		return activities;
	}

	public Activity getActivityByActid(int actId) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pStat = null;
		ResultSet rs = null;
		Activity activity = null;
		String sql = "select * from activity where actid=?";

		try {
			pStat = conn.prepareStatement(sql);
			pStat.setInt(1, actId);
			rs = pStat.executeQuery();
			if (rs.next()) {
				activity = new Activity();
				activity.setActid(actId);
				activity.setName(rs.getString(2));
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
			if (null != pStat) {
				try {
					pStat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBConnection.close(conn);
		}

		return activity;
	}
}
