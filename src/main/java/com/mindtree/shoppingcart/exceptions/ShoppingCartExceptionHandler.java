/**
 * 
 */
package com.mindtree.shoppingcart.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Sumathy
 *
 */

@Controller
@ControllerAdvice
public class ShoppingCartExceptionHandler {
	
	@ExceptionHandler(value=ProductNotFoundException.class)
	public String handleProductNotFoundException(Model model)
	{
		model.addAttribute("errMessage", "Product Not Found");
		return "error";
	}
	
	@ExceptionHandler(value=NullPointerException.class)
	public String handleNullPointerException(Model model)
	{
		
		model.addAttribute("errMessage","No Matched products Found");
		return "error";
		
	}
	
	@ExceptionHandler(value=NumberFormatException.class)
	public String handleNumberFormatException(Model model)
	{
		
		model.addAttribute("errMessage","Please check your input and try again");
		return "error";
		
	}
	
	@ExceptionHandler(value=IllegalArgumentException.class)
	public String handleIllegalArgumentException(Model model)
	{
		
		model.addAttribute("errMessage","Invalid input,Please check your input");
		return "error";
	}	
	
	@ExceptionHandler(value=UserNotFoundException.class)
	public String handleUserNotFoundException(Model model)
	{
		
		model.addAttribute("loginErrMessage","Invalid Login,UserName/Password is incorrect");
		return "error";
	}
	
	@ExceptionHandler(value=UserAlreadyExistsException.class)
	public String handleUserAlreadyExistsException(Model model)
	{
		
		model.addAttribute("regErrMessage","User Name already exists");
		return "error";
	}
	

}
