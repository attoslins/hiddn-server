package br.com.hiddn.hiddnserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.hiddn.hiddnserver.bean.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	@Query("SELECT c FROM Comment c WHERE card_id = ?1")
	List<Comment> findByCardId(@Param(value = "cardId") long cardId);

}