package com.cg.grocery.repository;


import com.cg.grocery.entities.*;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("bookDao")
public interface BookProductDAOInt extends JpaRepository<BookProductEntity,Long> {

//  public long add(BookProductEntity bean);
	
//	public void update(BookProductEntity bean);
	
//	public void delete(BookProductEntity bean);
	
	public BookProductEntity findByName(String name);
	
	@Query("SELECT od FROM BookProductEntity od where od.name like :nm")
	public List<BookProductEntity> searchbyname(@Param("nm") String name);
	
//	public BookProductEntity findByPk(long id);
	
//	public List<BookProductEntity> search(BookProductEntity bean, long pageNo, int pageSize);
	
	@Query("SELECT od FROM BookProductEntity od where od.name like :nm")
	public List<BookProductEntity> searchbynamep(@Param("nm") String name, Pageable p);
	
//	public List<BookProductEntity> search(BookProductEntity bean);
	
	
}
