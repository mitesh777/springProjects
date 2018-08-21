package com.springmvc.bookapp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.bookapp.dao.BookDAO;
import com.springmvc.bookapp.entities.Book;
import com.springmvc.bookapp.services.BookService;
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO dao;
	
	@Override
	public long addBook(Book book) {
		// TODO Auto-generated method stub
		return dao.saveBook(book);
	}

}
