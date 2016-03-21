package sport.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import sport.entity.Comment;
import sport.util.DBConnection;

public class CommentDao {
	public CommentDao() {
	}

	// 由商品id查询订单
	public List<Comment> GetCommentByGid(int gid) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		conn = DBConnection.getConnection();
		String sql = "SELECT * from comment where gid = ?";
		List<Comment> listComment = new ArrayList<Comment>();

		try {
			prep = conn.prepareStatement(sql);
			prep.setInt(1, gid);

			rs = prep.executeQuery();

			while (rs.next()) {
				// 如果查询到数据，获取数据再将其封装到comment对象中去
				Comment com = new Comment();
				com.setComid(rs.getInt("comid"));
				com.setUid(rs.getInt("uid"));
				com.setGid(rs.getInt("gid"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				rs.getDate("date");
				com.setDate(sdf.format(rs.getDate("date")));
				com.setContent(rs.getString("content"));
				com.setImgPath(rs.getString("imgpath"));
				listComment.add(com);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != prep) {
				try {
					prep.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBConnection.close(conn);
		}

		return listComment;

	}

	// 由评价单号查询出所有评价
	public Comment GetCommentByCid(int cid) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		Comment com = new Comment();

		String sql = "select * from comment where comid = ?";

		conn = DBConnection.getConnection();
		try {
			prep = conn.prepareStatement(sql);
			prep.setInt(1, cid);
			rs = prep.executeQuery();
			while (rs.next()) {
				com.setComid(rs.getInt("comid"));
				com.setUid(rs.getInt("uid"));
				com.setGid(rs.getInt("gid"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				rs.getDate("date");
				com.setDate(sdf.format(rs.getDate("date")));
				com.setContent(rs.getString("content"));
				com.setImgPath(rs.getString("imgpath"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != prep) {
				try {
					prep.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBConnection.close(conn);
		}
		return com;
	}

	// 查出所有评价信息
	public List<Comment> GetAllComment() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		List<Comment> listComment = new ArrayList<Comment>();
		String sql = "select * from comment";
		conn = DBConnection.getConnection();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				Comment com = new Comment();
				com.setComid(rs.getInt("comid"));
				com.setUid(rs.getInt("uid"));
				com.setGid(rs.getInt("gid"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				rs.getDate("date");
				com.setDate(sdf.format(rs.getDate("date")));
				com.setContent(rs.getString("content"));
				com.setImgPath(rs.getString("imgpath"));
				listComment.add(com);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return listComment;
	}

}
