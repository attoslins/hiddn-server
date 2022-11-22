package br.com.hiddn.hiddnserver.bean;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "Card")
@Table(name = "tb_card")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cardId;

	@CreationTimestamp
	@Column(name = "creation_date")
	private Calendar creationDate;

	@Column(name = "card_description", length = 255)
	private String cardDescription;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "thread_id", referencedColumnName = "threadId", updatable = false, insertable = true)
	private Thread threadName;

	@OneToMany(mappedBy = "card", fetch = FetchType.EAGER)
	private List<Comment> comments;

	public Card() {
		super();
	}

	public Card(String cardDescription) {
		super();
		this.cardDescription = cardDescription;
	}

	public Card(long cardId, Calendar creationDate, String cardDescription, List<Comment> comments) {
		super();
		this.cardId = cardId;
		this.creationDate = creationDate;
		this.cardDescription = cardDescription;
		this.comments = comments;
	}

	public long getCardId() {
		return cardId;
	}

	public void setCardId(long cardId) {
		this.cardId = cardId;
	}

	public Calendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}

	public String getCardDescription() {
		return cardDescription;
	}

	public void setCardDescription(String cardDescription) {
		this.cardDescription = cardDescription;
	}

	public Thread getThread() {
		return threadName;
	}

	public void setThread(Thread threadName) {
		this.threadName = threadName;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}