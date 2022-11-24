package br.com.hiddn.hiddnserver.bean;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "Thread")
@Table(name = "tb_thread")
public class Thread {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long threadId;

	@CreationTimestamp
	@Column(name = "creation_date")
	private Calendar creationDate;

	@Column(name = "thread_name", unique = true)
	private String threadName;

	public Thread() {
		super();
	}

	public long getThreadId() {
		return threadId;
	}

	public Thread(String threadName) {
		super();
		this.threadName = threadName;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

}