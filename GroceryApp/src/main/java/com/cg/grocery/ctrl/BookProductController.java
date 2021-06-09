package com.cg.grocery.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.grocery.entities.BookProductEntity;
import com.cg.grocery.entities.UserEntity;
import com.cg.grocery.service.BookProductServiceImpl;
import com.cg.grocery.service.UserServiceImpl;

@RestController
@RequestMapping("/Order")
public class BookProductController {
	
	@Autowired
	private BookProductServiceImpl bookprod;
	
	@PostMapping("/add")
	public ResponseEntity<String> addOrder(
				@RequestBody BookProductEntity od){
			try {
			bookprod.add(od);
			}
			catch(Exception e) {
				
			}
			return new ResponseEntity<String>("Book Product added", HttpStatus.OK);				
     	}
  /*	
	@GetMapping("/allOrder")
	public ResponseEntity<List<UserEntity>> getAllUser(){
		List<UserEntity> ul= bookprod.getAllb();
		if(ul.isEmpty()) {
			return new ResponseEntity("Sorry No Data", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<UserEntity>>(ul, HttpStatus.OK);
	}
	*/
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteOrder(
			@RequestBody BookProductEntity od){
		//long tempId=u.getId();
		bookprod.delete(od);
		
		return new ResponseEntity<String>("Book product Deleted", HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateOrder(
			@RequestBody BookProductEntity od){
			try {
			bookprod.update(od);
			}
			catch(Exception e) {
			}
		return new ResponseEntity<String>("Book product updated", HttpStatus.OK);
	}
	

	@GetMapping("/bookproducts/byname/{name}")
	public ResponseEntity<BookProductEntity> findByName(@PathVariable String name){
		BookProductEntity bookproducts= bookprod.findByName(name);
		if(bookproducts==null) {
			return new ResponseEntity("Sorry! Product is not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<BookProductEntity>(bookproducts, HttpStatus.OK);
	}
	
	@GetMapping("/bookproducts/byPk/{id}")
	public ResponseEntity<BookProductEntity> findByPk(@PathVariable long id){
		BookProductEntity bookproducts= bookprod.findByPk(id);
		if(bookproducts==null) {
			return new ResponseEntity("Sorry! Product is not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<BookProductEntity>(bookproducts, HttpStatus.OK);
	}
	
	@PutMapping("/searchorder/page")
	public ResponseEntity<List<BookProductEntity>> searchOrderpage(@RequestBody BookProductEntity od, int pageNo, int pageSize){
		
		List<BookProductEntity> ord= bookprod.search(od, 0, 2);
		if(ord.isEmpty()) {
			return new ResponseEntity("Sorry No Data", 
					HttpStatus.NOT_FOUND);

}
		return new ResponseEntity<List<BookProductEntity>>(ord, HttpStatus.OK);
	}
	
	@PostMapping("/searchorders")
	public ResponseEntity<List<BookProductEntity>> searchProduct(
			@RequestBody BookProductEntity odr){
		List<BookProductEntity> orders= bookprod.search(odr);
		if(orders.isEmpty()) {
			return new ResponseEntity("Sorry! Products not available!", 
					HttpStatus.NOT_FOUND);
		
	       }
		return new ResponseEntity<List<BookProductEntity>>(orders, HttpStatus.OK);
	
	        }
	
	
	
}
