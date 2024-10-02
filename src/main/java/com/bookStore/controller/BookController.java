package com.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RestController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookListService;

@Controller
public class BookController {
	
	private BookService bService;

    @Autowired
    public BookController(BookService bService) {
        this.bService = bService;
    }
    
    @Autowired
    private MyBookListService myBookService ;

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/available_Books")
	public ModelAndView getAllBook() {
		List<Book> list = bService.getAllBook();
//		ModelAndView m = new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book", list);
		
		return new ModelAndView("bookList","book",list);
	}	
	
	@GetMapping("/register_Books")
	public String registerBooks() {
		return "registerBooks";
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		bService.save(b); 
		return "redirect:/available_Books ";
	}
	
	@GetMapping("/my_Books")
	public String getMyBooks(Model model) {
		List<MyBookList> list = myBookService.getAllBooks();
		model.addAttribute("book", list);
		return "myBook";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id")int id) {
		Book b = bService.getBookById(id);
		MyBookList mb = new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBooks(mb);
		return "redirect:/my_Books";
	}
	
	@RequestMapping("/edit_Book/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Book b = bService.getBookById(id);
		model.addAttribute("book",b);
		return "bookEdit";
	}
	
	@RequestMapping("/delete_Book/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		bService.deleteById(id);
		return "redirect:/available_Books";
	}

	
	
}
