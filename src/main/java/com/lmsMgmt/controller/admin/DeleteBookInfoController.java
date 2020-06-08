package com.lmsMgmt.controller.admin;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmsMgmt.models.Book;
import com.lmsMgmt.service.IBookService;

@Controller
public class DeleteBookInfoController {

	@Autowired
	IBookService bookService;
	
	@PostMapping("/admin/library/deletebook/{isbin}")
	public ModelAndView updateBookInfo(@PathVariable("isbin") String isbinNo) {
		ModelAndView mv= new ModelAndView("redirect:/admin/books");
		
		
		bookService.deleteBookByIsbin(isbinNo);
		
		return mv;
	}
	
}
	
	


