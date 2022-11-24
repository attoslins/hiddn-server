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

	@GetMapping("/hello")
	public String helloWorld() {
		System.out.println("ThreadController => Hello World");
		return "Hello world!";
	}

	@PostMapping("/thread")
	public void createThread(@RequestBody br.com.hiddn.hiddnserver.bean.Thread thread) {
		// save a new Thread only if 'threadName' doesn't contain any blank spaces
		if (thread.getThreadName().contains(" ")) {
			throw new RuntimeException("Thread names cannot contain spaces");
		} else {
			repository.save(thread);
		}
	}

	@GetMapping("/thread/{threadName}")
	public br.com.hiddn.hiddnserver.bean.Thread getThread(@PathVariable String threadName) {

		br.com.hiddn.hiddnserver.bean.Thread thread = repository.findByThreadName(threadName);

		if (thread == null) {
			// Create a thread if it does not exist
			thread = new br.com.hiddn.hiddnserver.bean.Thread(threadName);
			repository.save(thread);
			return thread;
		} else {
			// return a thread if it already exists
			return thread;
		}
	}
}