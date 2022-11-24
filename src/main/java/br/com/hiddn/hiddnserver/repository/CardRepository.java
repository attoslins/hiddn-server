package br.com.hiddn.hiddnserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.hiddn.hiddnserver.bean.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

	@Query("SELECT c FROM Card c WHERE thread_id = ?1")
	List<Card> findByThreadId(long threadId);
}