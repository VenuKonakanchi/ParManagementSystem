package com.htc.par.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.htc.par.entity.Area;
import com.htc.par.repository.AreaRepository;
import com.htc.par.service.impl.AreaServiceImpl;
import com.htc.par.to.AreaTo;
 
/*
 * @ Author - Allen
 * Controller to handle Capability Area information 
 * 
 */

@RestController
public class AreaController {
	
	
	@Autowired
	AreaServiceImpl areaservice;
	
	@GetMapping(value="/area")
	public String area() {
		return "areaAndProductForm";
	}

	
	// GET METHODS

	@GetMapping(value="/Areas", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Area>> getAreas() {
		
		List<Area> areas = areaservice.getAreas();

		HttpHeaders header = new HttpHeaders();
		header.add("Access-Control-Allow-Origin", "*");
		header.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		header.add("Access-Control-Allow-Headers", "Content-Type");

		if(areas.isEmpty()) {
			ResponseEntity<List<Area>> response = new ResponseEntity<List<Area>>(header, HttpStatus.NO_CONTENT);
			return response;
		}
		else {
			ResponseEntity<List<Area>> response = new ResponseEntity<List<Area>>(areas, header, HttpStatus.OK);
			return response;
		}
	}
	
	
	
	// GET AREA ID
	
	@GetMapping(value="/Areas/{areaId}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AreaTo> getArea(@PathVariable("areaId") Integer areaId) {
		
		System.out.println("Inside get map");
		AreaTo areaTo = areaservice.getArea(areaId);
		System.out.println(areaTo);
		HttpHeaders header = new HttpHeaders();
		header.add("Access-Control-Allow-Origin", "*");
		header.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		header.add("Access-Control-Allow-Headers", "Content-Type");

		if(areaTo == null) {
			ResponseEntity<AreaTo> response = new ResponseEntity<AreaTo>(header, HttpStatus.NO_CONTENT);
			return response;
		}
		else {
			ResponseEntity<AreaTo> response = new ResponseEntity<AreaTo>(areaTo, header, HttpStatus.OK);
			return response;
		}
	}
	
	
	
 

	@PostMapping(value="/Areas", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Boolean> createArea(@RequestBody AreaTo areaTo) {
		
		boolean result = areaservice.addArea(areaTo);
		HttpHeaders header = new HttpHeaders();
		
		header.add("Access-Control-Allow-Origin", "*");
		header.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		header.add("Access-Control-Allow-Headers", "Content-Type");
		
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(result, header, HttpStatus.CREATED);
		
		return response;
		
	}
	
	
	
	/*

	@GetMapping(value="/Products/{productcode}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductTO> getProduct(@PathVariable("productcode") String productcode) {
		
		System.out.println("Inside get map");
		ProductTO productTo = productService.getProduct(productcode);
		System.out.println(productTo);
		HttpHeaders header = new HttpHeaders();
		header.add("Access-Control-Allow-Origin", "*");
		header.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		header.add("Access-Control-Allow-Headers", "Content-Type");

		if(productTo == null) {
			ResponseEntity<ProductTO> response = new ResponseEntity<ProductTO>(header, HttpStatus.NO_CONTENT);
			return response;
		}
		else {
			ResponseEntity<ProductTO> response = new ResponseEntity<ProductTO>(productTo, header, HttpStatus.OK);
			return response;
		}
	}
	
	*/
	
	/*

	@GetMapping(value="/Products", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getProducts() {
		
		List<Product> products = productService.getProducts();

		HttpHeaders header = new HttpHeaders();
		header.add("Access-Control-Allow-Origin", "*");
		header.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		header.add("Access-Control-Allow-Headers", "Content-Type");

		if(products.isEmpty()) {
			ResponseEntity<List<Product>> response = new ResponseEntity<List<Product>>(header, HttpStatus.NO_CONTENT);
			return response;
		}
		else {
			ResponseEntity<List<Product>> response = new ResponseEntity<List<Product>>(products, header, HttpStatus.OK);
			return response;
		}
	}
	
	*/

	/*
	@DeleteMapping(value="/Products/{productId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> deleteProduct(@PathVariable("productcode") String productcode) {
		boolean removed = productService.removeProduct(productcode);
		
		HttpHeaders header = new HttpHeaders();
		
		header.add("Access-Control-Allow-Origin", "*");
		header.add("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		header.add("Access-Control-Allow-Headers", "Content-Type");
		
		if(removed) {
			ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(removed, header, HttpStatus.OK);
			return response;
		}
		else {
			ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(header, HttpStatus.NOT_FOUND);
			return response;
			
		}		
	}
	
	*/
	
	
	
	
	

}
