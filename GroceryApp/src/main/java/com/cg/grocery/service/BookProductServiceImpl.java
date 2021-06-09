package com.cg.grocery.service;
import com.cg.grocery.entities.*;
import com.cg.grocery.exception.DuplicateRecordException;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.grocery.repository.BookProductDAOInt;

@Service
public class BookProductServiceImpl implements BookProductServiceInt{
	
		@Autowired
		private BookProductDAOInt bookDao; 
		
	public long add(BookProductEntity od) {
		Timestamp ts = Timestamp.from(ZonedDateTime.now().toInstant()); 
		od.setCreatedDateTime(ts);
		od.setCreatedBy(od.getName());
		bookDao.saveAndFlush(od);
		return od.getId();
	}
	public void update(BookProductEntity bean) {
		BookProductEntity src = bookDao.findById(bean.getId()).get();
		Timestamp ts = Timestamp.from(ZonedDateTime.now().toInstant());
		if(bean.getMobileNo()!=null ) {
			src.setMobileNo(bean.getMobileNo());
		}
		if(bean.getAddress()!=null) {
			src.setAddress(bean.getAddress());
		}
		if(bean.getEmailId()!=null) {
			src.setEmailId(bean.getEmailId());
		}
		if(bean.getQuantity()!=null) {
			src.setQuantity(bean.getQuantity());
		src.setModifiedDateTime(ts);
		src.setModifiedBy(bean.getName());
		bookDao.saveAndFlush(src);
		}
	}
	public void delete(BookProductEntity bean) {
		bookDao.deleteById(bean.getId());
	}
	public BookProductEntity findByName(String name) {
		return bookDao.findByName(name);
		}
	public BookProductEntity findByPk(long id) {
		return bookDao.findById(id).get();
	}
	public List<BookProductEntity> search(BookProductEntity bean){
		return bookDao.searchbyname(bean.getName());
	}
	public List<BookProductEntity> search(BookProductEntity bean, int pageNo, int pageSize) {
		 
	    return bookDao.searchbynamep(bean.getName(), PageRequest.of(pageNo, pageSize));
			
	}
	
}