package com.springmvc.bookapp.dao;

import com.springmvc.bookapp.entities.Book;

public interface BookDAO {
	
	long saveBook(Book book);
}
