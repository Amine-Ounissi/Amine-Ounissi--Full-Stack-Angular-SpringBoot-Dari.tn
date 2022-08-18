package tn.Dari.services;

import java.util.List;

import tn.Dari.entities.Comment;



public interface CommentService {

	

	void deletecomById(Long comId);
	
	Comment updatecom(Comment comment);
	
	String Blockcomments (Long comId);


	List<Comment> getallcoms();

	Comment findbyidCom(Long idc);


	boolean IncremDislike(Long idCom);

	boolean IncremLike(Long idCom);

	boolean DecremLike(Long idCom);

	boolean DecremDislike(Long idCom);

	void addCom(Comment c, long adid);




}
