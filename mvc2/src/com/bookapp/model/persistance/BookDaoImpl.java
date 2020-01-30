package com.bookapp.model.persistance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

	private SessionFactory sessionFactory;

	@Autowired
	public BookDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Book> getAllBooks() {
		return getSession().createQuery("from Book").list();
	}

	@Override
	public void deleteBook(int bookId) {
		Book bookToBeDeleted = getBookById(bookId);
		getSession().delete(bookToBeDeleted);
	}

	@Override
	public void updateBook(int bookId, double price) {
		Book bookToBeUpdated = getBookById(bookId);

		bookToBeUpdated.setPrice(price);
		getSession().update(bookToBeUpdated);

	}

	@Override
	public void addBook(Book book) {
		getSession().save(book);
	}

	@Override
	public Book getBookById(int bookId) {
		Book book = (Book) getSession().get(Book.class, bookId);
		if (book == null)
			throw new BookNotFoundException("book with id =" + bookId
					+ " is not found");
		return book;
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		Book book = (Book) getSession()
				.createQuery("select b from Book b where isbn=:isbn")
				.setString("isbn", isbn).uniqueResult();
		if(book==null)
			throw new BookNotFoundException("book with isbn "+isbn + " is not found");
		return book;
	}
}












