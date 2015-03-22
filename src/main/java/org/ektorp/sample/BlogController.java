package org.ektorp.sample;

import java.util.List;

import javax.servlet.http.*;

import org.ektorp.*;
import org.joda.time.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class BlogController {

	@Autowired
	BlogPostRepository blogPostRepo;
	@Autowired
	CommentRepository commentRepo;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewAll(Model m) {

	List<Comment>	commentList = commentRepo.getAll();
	
	BlogPost blogpost = commentList.get(0).getBlogPost().iterator().next();
	
		m.addAttribute("commentList",commentList);
		return "/posts/index";
	}

	@RequestMapping(value = "/posts/new", method = RequestMethod.GET)
	public ModelAndView newPost() {

		return new ModelAndView("/posts/edit", "command", new BlogPost());
	}

	@RequestMapping(value = "/posts", method = RequestMethod.POST)
	public String submitPost(@ModelAttribute("command") BlogPost post) {
		if (post.isNew()) {
			post.setId(createId(post.getBlogPostId()));
			post.setDateCreated(new DateTime());
			blogPostRepo.add(post);
		} else {
			blogPostRepo.update(post);
		}

		return "redirect:/posts/new";
	}

	@ExceptionHandler(UpdateConflictException.class)
	public ModelAndView onUpdateConflictException(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("posts/update_conflict");
		BlogPost existing = blogPostRepo.get(req.getParameter("title"));
		mav.addObject("command", existing);
		return mav;
	}

	private String createId(String title) {
		return title.replaceAll("\\s", "-");
	}

	@RequestMapping("/posts/{postId}")
	public ModelAndView viewPost(@PathVariable("postId") String postId) {
		ModelAndView model = new ModelAndView("/posts/view");
		model.addObject(blogPostRepo.get(postId));
		 model.addObject(commentRepo.findByBlogPostId(postId));
		return model;
	}

	@RequestMapping(value = "/posts/{postId}/edit", method = RequestMethod.GET)
	public BlogPost editPost(@PathVariable("postId") String postId) {
		return blogPostRepo.get(postId);
	}
	@RequestMapping(value = "/posts/newcomment", method = RequestMethod.GET)
	public ModelAndView newComment() {

		return new ModelAndView("/posts/comment", "command", new Comment());
	}
	@RequestMapping(value = "/posts/comment", method = RequestMethod.POST)
	public String addComment(
			@ModelAttribute("command") Comment comment) {
		comment.setBlogPostId(comment.getBlogPostId());
		comment.setDateCreated(new DateTime());
		blogPostRepo.addComment(comment);
		return "redirect:/posts/newcomment" ;//+ comment.getBlogPostId();
	}
}
