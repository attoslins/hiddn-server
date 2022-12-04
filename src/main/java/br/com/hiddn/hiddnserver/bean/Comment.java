package br.com.hiddn.hiddnserver.bean;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "Comment")
@Table(name = "tb_comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long commentId;

	@CreationTimestamp
	@Column(name = "creation_date")
	private Calendar creationDate;

	@Column(name = "comment_description")
	private String commentDescription;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "card_id", referencedColumnName = "cardId", updatable = false, insertable = true)
	private Card card;

	public Comment() {
		super();
	}

	public Comment(long commentId, Calendar creationDate, String commentDescription, Card card) {
		super();
		this.commentId = commentId;
		this.creationDate = creationDate;
		this.commentDescription = commentDescription;
		this.card = card;
	}

	public long getCommentId() {
		return commentId;
	}

	public Calendar getCreationDate() {
		return creationDate;
	}

	public String getCommentDescription() {
		return commentDescription;
	}

	public void setCard(Card card) {
		this.card = card;
	}
}