package com.lmsMgmt.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.collections.List;

import com.lmsMgmt.models.Book;
import com.lmsMgmt.repository.BookRepository;

@Service("bookService")
public class BookService implements IBookService{
	@Autowired
	BookRepository bookRepository;
	@Override
	public ArrayList<Book> getAllBooks(){
		ArrayList<Book> books = new ArrayList<>();
		Iterable<Book> itr= bookRepository.findAll();
		if(null!=itr) {
			for(Book book:itr) {
				books.add(book);
			}
		}
		return books;
	}
	@Override
	public Book saveBookRecord(Book book) {
		return bookRepository.save(book);
	}
	@Override
	public Book findBookByIsBinNo(String isbinNo) {
		return bookRepository.findByIsbin(isbinNo);
	}
	@Override
	public void deleteBookByIsbin(String isbinNo) {
		Book bookRecordToDelete= bookRepository.findByIsbin(isbinNo);
		bookRepository.delete(bookRecordToDelete);
	}

}
