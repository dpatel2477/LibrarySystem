package com.lmsMgmt.service;

import java.util.ArrayList;

import antlr.collections.List;

import com.lmsMgmt.models.Book;
public interface IBookService {
	
	public default ArrayList<Book> getAllBooks(){
		
		return new ArrayList<>();
	}
	public default Book saveBookRecord(Book book) {
		return null;
	}
	public default Book findBookByIsBinNo(String isbinNo) {
		return null;
	}
	public default void deleteBookByIsbin(String isbinNo) {
		
	}
		
	


}
