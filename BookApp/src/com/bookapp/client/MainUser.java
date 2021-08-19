package com.bookapp.client;

import java.util.List;
import java.util.Scanner;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookService;
import com.bookapp.service.BookServiceImpl;

public class MainUser {

	public static void main(String[] args) throws BookNotFoundException {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Enter the choice:\n1.Show All Books\n2.Show Book By Id\n3.Show Books by Author name\n4.Show Books by Category\n5.Show books having price lesser than the given price");
		int choice = scanner.nextInt();
		BookService bookService = new BookServiceImpl();
		switch (choice) {
		case 1:
			List<Book> bookList = bookService.getAllBooks();
			for (Book book : bookList) {
				System.out.println(book);
			}
			break;
		case 2:
			System.out.println("Enter the book id:");
			int bookId = scanner.nextInt();
			try {
				System.out.println(bookService.getBookById(bookId));
			} catch (BookNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 3:
			System.out.println("Enter the author name:");
			String authorName = scanner.next();
			try {
				System.out.println(bookService.getBookByAuthor(authorName));
			} catch (BookNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 4:
			System.out.println("Enter the category:");
			String category = scanner.next();
			try {
				System.out.println(bookService.getBookByCategory(category));
			} catch (BookNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 5:
			System.out.println("Enter the price:");
			double price = scanner.nextDouble();
			try {
				System.out.println(bookService.getBooksByLesserPrice(price));
			} catch (BookNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;

		}
	}

}
