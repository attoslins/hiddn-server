package br.com.hiddn.hiddnserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hiddn.hiddnserver.bean.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {

	List<Card> findByThreadName(String threadName);

}