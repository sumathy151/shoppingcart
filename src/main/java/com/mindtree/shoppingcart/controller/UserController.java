package com.mindtree.shoppingcart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.shoppingcart.exceptions.UserAlreadyExistsException;
import com.mindtree.shoppingcart.exceptions.UserNotFoundException;
import com.mindtree.shoppingcart.model.ProductDetails;
import com.mindtree.shoppingcart.model.UserDetails;
import com.mindtree.shoppingcart.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/home")
	public String displayLogin(Model model) {
		model.addAttribute("user", new UserDetails());
		return "login";
	}

	@RequestMapping(value = "/shoppingCart/search", method = RequestMethod.POST)

	public String validateUserDetails(@Valid @ModelAttribute("user") UserDetails user, BindingResult br,
			HttpServletRequest request) throws UserNotFoundException {

		if (br.hasErrors()) {
			return "login";
		} else {

			String encodedString = new String(Base64.encodeBase64(user.getPassword().getBytes()));

			user = userService.validateUser(user.getUserName(), encodedString);
			HttpSession session = request.getSession(true);
			session.setAttribute("userId", user.getUserId());

			return "searchPage";
		}
	}

	@RequestMapping(value = "/shoppingCart/search", method = RequestMethod.GET)

	public String displaySearch(Model model) {
		model.addAttribute("productDetails", new ProductDetails());
		return "searchPage";
	}

	@RequestMapping(value = "/home/registration", method = RequestMethod.GET)
	public String displayRegistration(Model model) {
		model.addAttribute("user", new UserDetails());
		return "registration";
	}

	@RequestMapping(value = "/home/registerUser", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") UserDetails user, BindingResult br)
			throws UserAlreadyExistsException {
		if (!br.hasErrors()) {
			String encodedString = new String(Base64.encodeBase64(user.getPassword().getBytes()));
			userService.registerUser(user.getUserName(), encodedString);
			return "registerSuccess";

		} else
			return "registration";

	}

}
