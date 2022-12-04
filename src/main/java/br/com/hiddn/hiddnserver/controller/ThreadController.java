package br.com.hiddn.hiddnserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.hiddn.hiddnserver.bean.Threadd;
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

	@GetMapping("/thread/{threadName}")
	public Threadd getThread(@PathVariable String threadName) {

		Threadd thread = repository.findByThreadName(threadName);

		if (thread == null) {
			// Create a thread if it does not exist
			thread = new Threadd(threadName);
			repository.save(thread);
			return thread;
		} else {
			// return a thread if it already exists
			return thread;
		}
	}

	@PostMapping("/thread")
	public Threadd createThread(@RequestBody Threadd thread) {
		// save a new Thread only if 'threadName' doesn't contain any blank spaces
		if (thread.getThreadName().contains(" ")) {
			throw new RuntimeException("Thread names cannot contain spaces");
		} else {
			repository.save(thread);
			return thread;
		}
	}
}