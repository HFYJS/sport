package sport.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sport.dao.PostCommentDao;
import sport.entity.PostComment;

public class PostCommentService {
	private PostCommentDao dao = new PostCommentDao();

	public PostCommentService() {

	}

	public Map<Integer, List<PostComment>> getAllPostCommentsByPid(int pid) {
		List<PostComment> postComments = dao.getAllPostCommentsByPid(pid);
		
		List<Integer> pres = new ArrayList<Integer>();
		for (PostComment postComment : postComments) {
			if (!pres.contains(postComment.getPrePComid())) {
				pres.add(postComment.getPrePComid());
			}
		}

		Map<Integer, List<PostComment>> map = new HashMap<Integer, List<PostComment>>();
		for (int i : pres) {
			List<PostComment> list = new ArrayList<PostComment>();
			for (PostComment postComment : postComments) {
				if (postComment.getPrePComid() == i) {
					list.add(postComment);
				}
			}
			map.put(i, list);
		}
		
		return map;
	}
}
