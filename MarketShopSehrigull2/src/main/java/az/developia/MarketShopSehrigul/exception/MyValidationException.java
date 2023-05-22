package az.developia.MarketShopSehrigul.exception;

import org.springframework.validation.BindingResult;

public class MyValidationException extends RuntimeException {
	
	private BindingResult br;
	
	public BindingResult getBr() {
		return br;
	}
	
public MyValidationException(BindingResult br) {
	this.br=br;
	
}

}
