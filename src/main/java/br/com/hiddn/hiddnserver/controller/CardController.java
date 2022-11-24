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

	@GetMapping("/card/{threadId}")
	public List<Card> getCards(@PathVariable String threadId) {
		System.out.println(threadId);
		long id = Long.parseLong(threadId);
		List<Card> cards = repository.findByThreadId(id);
		if (cards.isEmpty()) {
			return List.of(new Card(
					"A thread '" + threadId + "' está vazia! Vc pode ser o primeiro(a) a criar essa discussão!"));
		}
		return cards;
	}

	@PostMapping("/card")
	public void createCard(@RequestBody Card card) {
		repository.save(card);
	}
}