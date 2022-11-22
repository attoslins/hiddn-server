package br.com.hiddn.hiddnserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.hiddn.hiddnserver.bean.Card;
import br.com.hiddn.hiddnserver.repository.CardRepository;

@RestController
public class CardController {

	@Autowired
	private CardRepository repository;

	@GetMapping("/hello")
	public String helloWorld() {
		System.out.println("CardController => Hello World");
		return "Hello world!";
	}

	@GetMapping("/card/{threadName}")
	public List<Card> getCards(@PathVariable String threadName) {
		// List<Card> cards = repository.findByThreadName(threadName);
		List<Card> cards = repository.findByThreadName(threadName);
		if (cards.isEmpty()) {
			return List.of(new Card(
					"A thread '" + threadName + "' está vazia! Vc pode ser o primeiro(a) a criar essa discussão!"));
		}
		return cards;
	}

	@PostMapping("/card")
	public void createCard(@RequestBody Card card) {
		repository.save(card);
	}
}