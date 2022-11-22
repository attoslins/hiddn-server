package br.com.hiddn.hiddnserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.hiddn.hiddnserver.repository.ThreadRepository;

@RestController
public class ThreadController {

	@Autowired
	private ThreadRepository repository;

	@PostMapping("/thread")
	public void createThread(@RequestBody br.com.hiddn.hiddnserver.bean.Thread thread) {
		repository.save(thread);
	}

	@GetMapping("/thread/{threadId}")
	public long getThread(@PathVariable long threadId) {

		br.com.hiddn.hiddnserver.bean.Thread thread = repository.findById(threadId);

		if (thread == null) {
			throw new RuntimeException("Comment not found with id " + threadId);
		}
		return thread.getThreadId();
	}

}
