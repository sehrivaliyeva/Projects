package az.developia.MarketShopSehrigul.aop;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.MarketShopSehrigul.exception.MyValidationException;

@RestControllerAdvice
public class MyAop {
	
	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ArrayList<String> handle(MyValidationException exc){
	  BindingResult br=exc.getBr();
	  ArrayList<String> errors=new ArrayList<>();
	  for (FieldError err : br.getFieldErrors()) {
		errors.add(err.getField()+":::"+err.getDefaultMessage());
	}
	  return errors;
	}
	

}
