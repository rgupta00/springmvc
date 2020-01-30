package com.bookapp.web.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookapp.model.persistance.Book;
import com.bookapp.model.service.BookService;

@Controller
public class BookController {
	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	// we wnat to do post operation in spring mvc
	// we have to write 2 method : one for get and 2. for post

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, ModelMap map) {
		return "redirect:/allbooks";
	}
	
	@RequestMapping(value = "updatebook", method = RequestMethod.GET)
	public String updateBookGet(HttpServletRequest request, ModelMap map) {
		int bookId = Integer.parseInt(request.getParameter("id"));
		map.addAttribute("book", bookService.getBookById(bookId));

		return "addbook";
	}

	@RequestMapping(value = "addbook", method = RequestMethod.GET)
	public String addBookGet(ModelMap map) {
		map.addAttribute("book", new Book());
		return "addbook";
	}

	// PRG
	@RequestMapping(value = "addbook", method = RequestMethod.POST)
	public String addAndUpdateBook(@Valid @ModelAttribute(value = "book")
	Book book , BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			return "addbook";
		}else{
		if(book.getBookId()==null)
			bookService.addBook(book);
		else
			bookService.updateBook(book.getBookId(), book.getPrice());
		return "redirect:/allbooks";
		}
	}

	@RequestMapping(value = "deletebook", method = RequestMethod.GET)
	public String deletebook(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id").trim());
		bookService.deleteBook(id);
		return "redirect:/allbooks";
	}

	@RequestMapping(value = "allbooks", method = RequestMethod.GET)
	public String showAllbooks(ModelMap map) {
		List<Book> books = bookService.getAllBooks();
		// map.addAttribute put the data into request scope
		map.addAttribute("books", books);
		return "allbooks";
	}
}
