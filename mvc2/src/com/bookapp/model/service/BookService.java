package com.bookapp.model.service;

import java.util.List;

import com.bookapp.model.persistance.Book;
//SL=BL+CCC
public interface BookService {
	public List<Book> getAllBooks();
	public void deleteBook(int bookId);
	public void updateBook(int bookId,double prices);
	public void addBook(Book book);
	public Book getBookById(int bookId);
	public Book getBookByIsbn(String isbn);
}
