package com.bookapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.model.persistance.Book;
import com.bookapp.model.persistance.BookDao;

@Service
@Transactional //it apply tx in declerative way using AOP
public class BookServiceImpl implements BookService {

	private BookDao bookDao;
	
	@Autowired
	public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	@Override
	public void deleteBook(int bookId) {
		bookDao.deleteBook(bookId);
	}

	@Override
	public void updateBook(int bookId, double prices) {
		bookDao.updateBook(bookId, prices);
	}

	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	@Override
	public Book getBookById(int bookId) {
		return bookDao.getBookById(bookId);
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		return bookDao.getBookByIsbn(isbn);
	}

}




