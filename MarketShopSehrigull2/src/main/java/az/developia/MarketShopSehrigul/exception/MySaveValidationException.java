package az.developia.MarketShopSehrigul.exception;

import org.springframework.validation.BindingResult;

public class MySaveValidationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private BindingResult br;
	
	public BindingResult getBr() {
		return br;
	}
	
	public void setBr(BindingResult br) {
		this.br = br;
	}
	
public MySaveValidationException(BindingResult br) {
	super();
	this.br=br;
	
}

}
