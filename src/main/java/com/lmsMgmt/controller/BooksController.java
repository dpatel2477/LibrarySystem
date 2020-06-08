package com.lmsMgmt.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmsMgmt.models.Book;
import com.lmsMgmt.service.IBookService;

import antlr.collections.List;

@Controller
public class BooksController {
	@Autowired
	IBookService bookService;
	
	@GetMapping("app/books")
	
	public ModelAndView getAllBooksPage() {
		ArrayList<Book> bookList= bookService.getAllBooks();
		ModelAndView mv= new ModelAndView("app/library/allBooks");
		mv.addObject("books", bookList);
		return mv;
		
		
	}

}
