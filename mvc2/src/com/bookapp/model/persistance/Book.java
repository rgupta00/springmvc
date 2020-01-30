package com.bookapp.model.persistance;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "book_table_hib_spring")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	
	
	@Column(unique = true, nullable = false)
	@NotEmpty
	private String isbn;

	@Column(nullable = false)
	@NotEmpty
	private String title;
	
	@NotNull
	@Min(value=10, message="min price should be more then 10")
	@Max(value=10000, message="max price should be less then 10000")
	@Column(nullable = false)
	private Double price;
	
	
	@Column(nullable = false)
	@NotEmpty
	private String author;
	
	
	@Column(nullable = false)
	@NotEmpty
	private String publisher;
	
	@NotNull
	@Past
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date pubDate;

	public Book() {
	}

	public Book(String isbn, String title, Double price, String author,
			String publisher, Date pubDate) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.pubDate = pubDate;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", isbn=" + isbn + ", title=" + title
				+ ", price=" + price + ", author=" + author + ", publisher="
				+ publisher + ", pubDate=" + pubDate + "]";
	}

	
}
