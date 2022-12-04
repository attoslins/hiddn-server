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
	private Threadd thread;

	@OneToMany(mappedBy = "card", fetch = FetchType.LAZY)
	private List<Comment> comments;

	public Card() {
		super();
	}

	public Card(String cardDescription) {
		super();
		this.cardDescription = cardDescription;
	}

	public Card(long cardId, Calendar creationDate, String cardDescription, Threadd thread) {
		super();
		this.cardId = cardId;
		this.creationDate = creationDate;
		this.cardDescription = cardDescription;
		this.thread = thread;
	}

	public long getCardId() {
		return cardId;
	}

	public Calendar getCreationDate() {
		return creationDate;
	}

	public String getCardDescription() {
		return cardDescription;
	}

	public void setThread(Threadd thread) {
		this.thread = thread;
	}

}