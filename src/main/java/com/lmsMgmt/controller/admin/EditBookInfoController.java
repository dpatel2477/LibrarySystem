package com.lmsMgmt.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmsMgmt.models.Book;
import com.lmsMgmt.service.IBookService;

@Controller
public class EditBookInfoController {
	@Autowired
	@Qualifier("bookValidator")
	Validator bookValidator;
	
	@InitBinder("book")
	public void initbinder(WebDataBinder dataBinder) {
		dataBinder.setValidator(bookValidator);
	}
	
	@Autowired
	IBookService bookService;
	
	@GetMapping("/admin/library/editbookinfo/{isbin}")
	public ModelAndView getEditPage(@PathVariable("isbin") String isbinNo) {
		ModelAndView mv= new ModelAndView("admin/library/editbookinfo");
		Book book= bookService.findBookByIsBinNo(isbinNo);
		mv.addObject("book", book);
		return mv;
	}
	
	@PostMapping("/admin/library/editbookinfo/{isbin}")
	public ModelAndView updateBookInfo(@ModelAttribute("book")@Valid Book bookToUpdate,BindingResult result) {
		ModelAndView mv= new ModelAndView("redirect:/admin/books");
		if(result.hasErrors()) {
			mv.setViewName("admin/library/editbookinfo");
			mv.addObject("book", bookToUpdate);
			return mv;
		}
		
		 bookService.saveBookRecord(bookToUpdate);
		
		return mv;
	}
	
}
	
	


