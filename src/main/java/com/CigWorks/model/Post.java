package com.CigWorks.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "post")
public class Post implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;

	@NotEmpty
	@Column(name="title")
	private String title;
	
	@NotEmpty
	@Column(name="body",columnDefinition = "TEXT")
	private String body;
	
	@Column(name="teacher",columnDefinition = "TEXT")
	private String teaser;
	
	@NotEmpty
	@Column(name="slug")
	private String slug;
	
	//@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_on_posted")
	private Date postedOn;

	
	@Size(min = 1,max = 2)
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name = "keywords" )
	private List<String> keywords;
	
	@Column(name="status")
	private Boolean active;
	
	@ManyToOne
	//@JoinColumn(referencedColumnName = "id")
	private Author author;

	//@NotEmpty
	@Column(name = "authorn_Name")
	private String authornName;
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(String title) {
		this.setTitle(title);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTeaser() {
		return teaser;
	}

	public void setTeaser(String teaser) {
		this.teaser = teaser;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	
	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	

	public String getAuthornName() {
		return authornName;
	}

	public void setAuthornName(String authornName) {
		this.authornName = authornName;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body + ", teaser=" + teaser + ", slug=" + slug
				+ ", postedOn=" + postedOn + ", keywords=" + keywords + ", active=" + active + ", author=" + author + "]";
	}
		
	
}
