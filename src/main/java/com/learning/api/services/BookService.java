package com.learning.api.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.api.dao.BookRepository;
import com.learning.api.model.Book;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	
//	private static List<Book> list = new ArrayList<>();
	
//	static{
//		list.add(new Book(34, "JavaBook1", "abc"));
//		list.add(new Book(56, "JavaBook2", "def"));
//		list.add(new Book(78, "JavaBook3", "ijk"));
//	}
	
	
	//get all books 
	public List<Book> getBooks() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}
	
	//get book by id
	public Book getBookById(int id) {
		
		Book book = null;
		try {
			book = 	this.bookRepository.findById(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	//Adding the book 
	public Book addBook(Book book) {
		Book result = bookRepository.save(book);
		return result;
	}
	
	//Delete book
	public void deleteBook(int id) {
		//list = list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
		bookRepository.deleteById(id);
	}

	//Update book
	public void updateBook(Book book, int id) {
//		list = list.stream().map(b->{
//			if(b.getId()==id) {
//				b.setName(book.getName());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		
		book.setId(id);
		bookRepository.save(book);
		
	}
	
}
