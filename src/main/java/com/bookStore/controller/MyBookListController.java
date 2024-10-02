package com.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookStore.entity.MyBookList;
import com.bookStore.service.MyBookListService;


@Controller
public class MyBookListController {

	@Autowired
	private MyBookListService myService;
	
	@RequestMapping("/deleteList/{id}")
	public String deleteMyList(@RequestParam int id) {
		myService.deleteById(id);
		return "redirect:/my_Books";
	} 
}
