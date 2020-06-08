package com.lmsMgmt.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmsMgmt.models.Book;
import com.lmsMgmt.models.validators.BookValidator;
import com.lmsMgmt.service.IBookService;
import javax.validation.Valid;


@Controller
public class AddNewBookController {
	
	@Autowired
	IBookService bookService;
	
	@Autowired
	@Qualifier("bookValidator")
	Validator bookValidator;
	
	@InitBinder
	public void initbinder(WebDataBinder dataBinder) {
		dataBinder.setValidator(bookValidator);
	}
	
	@GetMapping("/admin/addbook")
	public ModelAndView getIndexPage() {
		ModelAndView mv = new ModelAndView("admin/library/addbook");
		mv.addObject("book", new Book());
		return mv;
	}
	@PostMapping("/admin/addbook")
	public ModelAndView addBookRecord(@ModelAttribute("book")@Valid Book book, BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:/admin");
		
		if(result.hasErrors()) {
			mv.setViewName("admin/library/addbook");
			mv.addObject("book", book);
			return mv;
		}
		bookService.saveBookRecord(book);

		return mv;
	}
	

}
