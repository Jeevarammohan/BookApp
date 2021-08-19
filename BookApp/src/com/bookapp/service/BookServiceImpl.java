package com.bookapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImpl implements BookService {

	@Override
	public Book getBookById(int bookId) throws BookNotFoundException {
		List<Book> bookList = getAllBooks();
		for (Book book : bookList) {
			if (bookId == book.getBookId()) {
				return book;
			}
		}
		throw new BookNotFoundException("Book not found for the given id");

	}

	@Override
	public List<Book> getBookByAuthor(String author) throws BookNotFoundException {
		int flag = 0;
		List<Book> bookList = getAllBooks();
		List<Book> result = new ArrayList<>();
		for (Book book : bookList) {
			if (author.equals(book.getAuthor())) {
				result.add(book);
				flag = 1;
			}
		}
		if (flag == 0) {
			throw new BookNotFoundException("Books not found for the given author");
		}
		return result;

	}

	@Override
	public List<Book> getBookByCategory(String category) throws BookNotFoundException {
		int flag = 0;
		List<Book> bookList = getAllBooks();
		List<Book> result = new ArrayList<>();
		for (Book book : bookList) {
			if (category.equals(book.getCategory())) {
				result.add(book);
				flag = 1;
			}
		}
		if (flag == 0) {
			throw new BookNotFoundException("Books not found for the given category");
		}
		return result;

	}

	@Override
	public List<Book> getAllBooks() {
		return showBooks();
	}

	@Override
	public List<Book> getBooksByLesserPrice(double price) throws BookNotFoundException {
		int flag = 0;
		List<Book> bookList = getAllBooks();
		List<Book> result = new ArrayList<>();
		for (Book book : bookList) {
			if (price>book.getPrice()) {
				result.add(book);
				flag = 1;
			}
		}
		if (flag == 0) {
			throw new BookNotFoundException("Books not found for lesser price than the given price");
		}
		return result;
	}

	private List<Book> showBooks() {
		return Arrays.asList(new Book("abc", "xyz", "romcom", 3546, 121), new Book("def", "wyx", "comedy", 1546, 131),
				new Book("jkl", "anc", "action", 2346, 161));
	}

}
