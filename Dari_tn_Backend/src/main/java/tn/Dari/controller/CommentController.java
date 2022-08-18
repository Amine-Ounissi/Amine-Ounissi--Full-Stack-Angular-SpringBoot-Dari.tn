package tn.Dari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.Dari.entities.Comment;
import tn.Dari.services.CommentService;
;



@RestController
@RequestMapping ("/App/announcement/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/test")
	public String test() {
		return "working fine ! " ; 
	}
	
	
	@GetMapping("/getallcom")
	public List<Comment> show() {
		List<Comment> coms = commentService.getallcoms() ; 
		return coms ; 
	}
	
	@GetMapping("/getcom/{comId}")
	public Comment findidcom(@PathVariable("comId") Long comId) {
		 
		return commentService.findbyidCom(comId); 
	}
	
	@PostMapping("/addcom/{adid}") 
	public String addingcom(@RequestBody Comment c,@PathVariable("adid") Long adId) {
		commentService.addCom(c,adId);
		return "Comment added!"; 
	}
	/*{
	"CommentId" : 1,
	"Description":"ezrzefrefdsq", 
	"LikesNb": 1,
	"DislikeNb":2,
	"Blocked": true,
	"Ads": 1,
	"User": 2
	
}*/
	
	@DeleteMapping("/deletecom/{comId}")
	public void DeletecomById(@PathVariable("comId") Long comId) {
		commentService.deletecomById(comId);
	}
	
	@PutMapping("/updatecom")
	@ResponseBody  
	public Comment Updatecom (@RequestBody Comment comment)  {
		return commentService.updatecom(comment);	
		
	}
	
	
	@PutMapping(value = "/BlockComments/{comId}")
	@ResponseBody
	public String BlockComments(@PathVariable long comId)  {
		 return commentService.Blockcomments(comId);
	}
	
	@PutMapping(value = "/inclike/{comId}")
	@ResponseBody
	public boolean inclike(@PathVariable long comId)  {
		 return commentService.IncremLike(comId);
	}
	
	@PutMapping(value = "/incdislike/{comId}")
	@ResponseBody
	public boolean incdislike(@PathVariable long comId)  {
		 return commentService.IncremDislike(comId);
	}
	
	
	@PutMapping(value = "/declike/{comId}")
	@ResponseBody
	public boolean declike(@PathVariable long comId)  {
		 return commentService.DecremLike(comId);
	}
	
	@PutMapping(value = "/decdislike/{comId}")
	@ResponseBody
	public boolean decdislike(@PathVariable long comId)  {
		 return commentService.DecremDislike(comId);
	}
	
	
	
	
	
	}
	
	
	
	
