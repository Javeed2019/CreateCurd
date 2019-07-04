package com.CigWorks.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class PostRequest implements Serializable
{
	private static final long serialVersionUID = 1L;

	private long id;

	private String title;
	
	private String body;
	
	private String teaser;
	
	private String slug;
	
	private Date postedOn;

	private List<String> keywords;
	
	private Boolean active;
	
	private long author;

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

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body + ", teaser=" + teaser + ", slug=" + slug
				+ ", postedOn=" + postedOn + ", keywords=" + keywords + ", active=" + active + ", author=" + author + "]";
	}

	public long getAuthor() {
		return author;
	}

	public void setAuthor(long authorId) {
		this.author = authorId;
	}
		
	
}
