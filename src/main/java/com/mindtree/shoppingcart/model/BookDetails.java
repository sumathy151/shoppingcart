package com.mindtree.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class BookDetails extends ProductDetails {

	
	private String genre;
	private String author;
	private String publications;

	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublications() {
		return publications;
	}

	public void setPublications(String publications) {
		this.publications = publications;
	}

	@Override
	public String toString() {
		return "BookDetails [genre=" + genre + ", author=" + author + ", publications=" + publications + "]";
	}
	
	

}
