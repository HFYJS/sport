package sport.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sport.entity.PostComment;
import sport.util.DBConnection;

public class PostCommentDao {
	public PostCommentDao() {

	}

	public List<PostComment> getAllPostCommentsByPid(int pid) {
		Connection conn = DBConnection.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		List<PostComment> postComments = new ArrayList<PostComment>();
		String sql = "select * from post_comment where pid=" + pid;

		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				PostComment postComment = new PostComment();
				postComment.setpComid(rs.getInt(1));
				postComment.setPid(pid);
				postComment.setUid(rs.getInt(3));
				// postComment.setDate(new Date(rs.getDate(4).getTime()));
				postComment.setDate(rs.getDate(4));
				postComment.setContent(rs.getString(5));
				postComment.setPrePComid(rs.getInt(6));
				postComment.setIsLast(rs.getInt(7));
				postComments.add(postComment);
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

		return postComments;
	}
}
