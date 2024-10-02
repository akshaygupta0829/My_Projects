package com.bookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.MyBookList;
import com.bookStore.repository.MyBookListRepository;

import java.util.*;

@Service
public class MyBookListService {

	@Autowired
	private MyBookListRepository myBook;
	
	public void saveMyBooks(MyBookList book) {
		myBook.save(book);
	}
	
	public List<MyBookList> getAllBooks(){
		return myBook.findAll();
	}
	
	public void deleteById(int id) {
		myBook.deleteById(id);
	}
}
