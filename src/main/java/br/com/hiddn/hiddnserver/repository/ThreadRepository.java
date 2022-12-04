package br.com.hiddn.hiddnserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hiddn.hiddnserver.bean.Threadd;

@Repository
public interface ThreadRepository extends JpaRepository<Threadd, Long> {

	Threadd findById(long threadId);

	Threadd findByThreadName(String threadName);
}