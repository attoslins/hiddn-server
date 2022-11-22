package br.com.hiddn.hiddnserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.hiddn.hiddnserver.bean.Comment;
import br.com.hiddn.hiddnserver.repository.CommentRepository;

@RestController
public class CommentController {

	@Autowired
	private CommentRepository repository;

	@PostMapping("/comment")
	public void createComment(@RequestBody Comment comment) {
		repository.save(comment);
	}

	@GetMapping("/comment/{cardId}")
	public List<Comment> getComments(@PathVariable long cardId) {

		List<Comment> comments = repository.findByCardId(cardId);
		if (comments.isEmpty()) {
			throw new RuntimeException("Comment not found with id " + cardId);
		}
		return comments;
	}

}
