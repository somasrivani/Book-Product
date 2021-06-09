package com.cg.grocery.service;
import com.cg.grocery.entities.*;
import com.cg.grocery.exception.DuplicateRecordException;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public interface BookProductServiceInt {

	public long add(BookProductEntity bean);
	
	public void update(BookProductEntity bean);
	
	public void delete(BookProductEntity bean);
	
    public BookProductEntity findByName(String name);
	
	public BookProductEntity findByPk(long id);
	
//	public List<BookProductEntity> search(BookProductEntity bean, long pageNo, int pageSize);
	
//	public List<BookProductEntity> search(BookProductEntity bean);
	
}