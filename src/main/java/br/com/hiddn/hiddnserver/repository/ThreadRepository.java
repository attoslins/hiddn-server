package br.com.hiddn.hiddnserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreadRepository extends JpaRepository<br.com.hiddn.hiddnserver.bean.Thread, Long> {

	br.com.hiddn.hiddnserver.bean.Thread findById(long threadId);

	br.com.hiddn.hiddnserver.bean.Thread findByThreadName(String threadName);
}