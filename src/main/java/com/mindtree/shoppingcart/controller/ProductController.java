package com.mindtree.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.mindtree.shoppingcart.exceptions.ProductNotFoundException;
import com.mindtree.shoppingcart.model.ApparelDetails;
import com.mindtree.shoppingcart.model.BookDetails;
import com.mindtree.shoppingcart.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService prodService;

	@RequestMapping(value = "/shoppingCart/search/products", method = RequestMethod.GET)

	public String findProducts(@RequestParam("searchOption") String searchOption,
			@RequestParam("searchKey") String searchKey, Model model)
			throws NumberFormatException, ProductNotFoundException {
		String viewPage = null;

		if (searchOption.equals("productId")) {

			viewPage = findProductById(Integer.valueOf(searchKey), model);

		} else if (searchOption.equals("productName")) {

			viewPage = findProductByName(searchKey, model);
		} else if (searchOption.equals("book")) {

			viewPage = findAllBookProducts(model);
		} else if (searchOption.equals("apparel")) {

			viewPage = findAllApparelProducts(model);
		}

		return viewPage;

	}

	/**
	 * @param model
	 * @return
	 * @throws ProductNotFoundException
	 */
	@RequestMapping("/apparelCategory")
	public String findAllApparelProducts(Model model) throws ProductNotFoundException {
		List<ApparelDetails> apparelDetails = prodService.findAllApparelProducts();
		if (CollectionUtils.isEmpty(apparelDetails)) {

			throw new ProductNotFoundException("Product Not Found");
		} else {
			model.addAttribute("apparelDetails", apparelDetails);
			return "searchPage";
		}
	}

	@RequestMapping("/Id")
	public String findProductById(int id, Model model) throws ProductNotFoundException {
		Object idObj = prodService.findProductById(id);
		return getProdByIdView(idObj, model);
	}

	@RequestMapping("/prodName")
	public String findProductByName(String name, Model model) throws ProductNotFoundException {
		List<Object> nameObjList = prodService.findProductByName(name);
		return getProdByNameView(nameObjList, model);

	}

	@RequestMapping("/bookCategory")
	public String findAllBookProducts(Model model) throws ProductNotFoundException {
		List<BookDetails> bookDetails = prodService.findAllBookProducts();
		if (CollectionUtils.isEmpty(bookDetails)) {
			throw new ProductNotFoundException("Product Not Found");
		} else {
			model.addAttribute("bookDetails", bookDetails);
			return "searchPage";
		}
	}

	/**
	 * @param nameObjList
	 * @return
	 * @throws ProductNotFoundException
	 */
	public String getProdByNameView(List<Object> nameObjList, Model model) throws ProductNotFoundException {
		String viewPage = null;

		if (CollectionUtils.isEmpty(nameObjList)) {

			throw new ProductNotFoundException("Product Not Found");

		} else {

			if (nameObjList.get(0) instanceof BookDetails) {
				List<BookDetails> bookDetails = new ArrayList<>();
				nameObjList.forEach(obj -> bookDetails.add((BookDetails) obj));
				model.addAttribute("bookDetails", bookDetails);

				viewPage = "searchPage";
			}

			else if (nameObjList.get(0) instanceof ApparelDetails) {
				List<ApparelDetails> apparelDetails = new ArrayList<>();
				nameObjList.forEach(obj -> apparelDetails.add((ApparelDetails) obj));
				model.addAttribute("apparelDetails", apparelDetails);
				viewPage = "searchPage";

			}
		}

		return viewPage;
	}

	/**
	 * @param prodObj
	 * @return
	 * @throws ProductNotFoundException
	 */
	public String getProdByIdView(Object prodObj, Model model) throws ProductNotFoundException {
		String viewPage = null;

		if (((Optional<?>) prodObj).isPresent()) {

			if (prodObj.toString().contains("BookDetails")) {
				BookDetails bookDetails = (BookDetails) ((Optional<?>) prodObj).get();
				model.addAttribute("bookDetails", bookDetails);

				viewPage = "searchPage";

			} else if (prodObj.toString().contains("ApparelDetails")) {
				ApparelDetails apparelDetails = (ApparelDetails) ((Optional<?>) prodObj).get();
				model.addAttribute("apparelDetails", apparelDetails);
				viewPage = "searchPage";
			}
		} else {
			throw new ProductNotFoundException("Product Not Found");
		}
		return viewPage;
	}

}
