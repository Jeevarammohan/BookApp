package com.bookapp.service;

import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public interface BookService {
	Book getBookById(int bookId) throws BookNotFoundException;

	List<Book> getBookByAuthor(String author) throws BookNotFoundException;

	List<Book> getBookByCategory(String category) throws BookNotFoundException;

	List<Book> getAllBooks();

	List<Book> getBooksByLesserPrice(double price) throws BookNotFoundException;

}
