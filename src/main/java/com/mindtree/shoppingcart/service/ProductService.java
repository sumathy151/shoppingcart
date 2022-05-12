package com.mindtree.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.shoppingcart.model.ApparelDetails;
import com.mindtree.shoppingcart.model.BookDetails;
import com.mindtree.shoppingcart.repository.ApparelRepository;
import com.mindtree.shoppingcart.repository.BookRepository;
import com.mindtree.shoppingcart.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private BookRepository bookRepo;

	@Autowired
	private ApparelRepository apparelRepo;

	@Autowired
	private ProductRepository prodRepo;

	@Autowired

	public List<BookDetails> findAllBookProducts() {

		List<BookDetails> bookList = (List<BookDetails>) bookRepo.findAll();
		return bookList;

	}

	public List<ApparelDetails> findAllApparelProducts() {
		List<ApparelDetails> apparelList = (List<ApparelDetails>) apparelRepo.findAll();
		return apparelList;

	}

	public Object findProductById(int id) {

		Object idObj = prodRepo.findById(id);
		return idObj;

	}

	public List<Object> findProductByName(String name) {
		List<Object> nameObjList = prodRepo.findByProductName(name);
		return nameObjList;
	}

}
