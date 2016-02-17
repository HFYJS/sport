package sport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sport.entity.Cate;
import sport.util.DBConnection;

public class CateDao {
	public CateDao() {

	}

	public List<Cate> search() {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		List<Cate> cates = new ArrayList<Cate>();
		String sql = "select * from cate order by catid";

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				Cate cate = new Cate();
				cate.setCatid(rs.getInt(1));
				cate.setName(rs.getString(2));
				cates.add(cate);
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

		return cates;
	}

	public Cate getCateByCatid(int catId) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pStat = null;
		ResultSet rs = null;
		Cate cate = null;
		String sql = "select * from cate where catid=?";

		try {
			pStat = conn.prepareStatement(sql);
			pStat.setInt(1, catId);
			rs = pStat.executeQuery();
			if (rs.next()) {
				cate = new Cate();
				cate.setCatid(catId);
				cate.setName(rs.getString(2));
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

		return cate;
	}
}
