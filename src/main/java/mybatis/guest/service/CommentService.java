package mybatis.guest.service;

import java.util.*;

import mybatis.guest.model.Comment;
import mybatis.guest.session.CommentRepository;
 
public class CommentService {
	
	private static CommentService service;
	
	private CommentService() {}
	public static CommentService getInstance(){
		if( service == null) service = new CommentService();
		return service;
	}
	
	// 모델단(JDBC) - DAO - Repository
	private CommentRepository reps = new CommentRepository();
	
	public List<Comment> selectComment(){
		return reps.selectComment();	// 화면에서 넘겨온 정보를 모델단으로 옮겨줌
	}
	
	public Comment selectCommentByPrimaryKey(int cId) {
		return reps.selectCommentByPK(cId);
	}
	
	public void insertComment(Comment c) {
		reps.insertComment(c);
	}
	
	public void deleteComment(Comment c) {
		reps.deleteComment(c);
	}
	
	public void updataComment(Comment c) {
		reps.updataComment(c);
	}

} 