package com.lmsMgmt.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmsMgmt.models.Book;
import com.lmsMgmt.repository.BookRepository;

@Controller
public class AppController {
	@Autowired
	BookRepository bookRepository;
	
	
	@GetMapping("/app")
	public ModelAndView getIndexPage() {
		Iterable<Book> itr= bookRepository.findAll();
		for(Book book:itr) {
			System.out.println(book.getBookTitle());
		}
	
		return new ModelAndView("app/index");
		
		
	}
	
	
}
