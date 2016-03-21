package sport.service;

import java.util.List;

import sport.dao.CommentDao;
import sport.entity.Comment;

public class CommentService {
	CommentDao commentDao = new CommentDao();

	// 根据gid查出comment
	public List<Comment> getCommentByGid(int gid) {
		return commentDao.GetCommentByGid(gid);

	}

	// 根据Cid查出comment
	public Comment getCommentByCid(int cid) {
		return commentDao.GetCommentByCid(cid);
	}

	// 查出所有订单

	public List<Comment> getAllComment() {
		return commentDao.GetAllComment();
	}
}
