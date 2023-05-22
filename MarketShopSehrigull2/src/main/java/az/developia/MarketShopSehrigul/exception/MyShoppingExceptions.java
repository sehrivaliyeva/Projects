package az.developia.MarketShopSehrigul.exception;

import java.util.List;

import org.springframework.validation.BindingResult;

public class MyShoppingExceptions extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private BindingResult br;

	public BindingResult getBr() {
		return br;
	}

	public void setBr(BindingResult br) {
		this.br = br;
	}

	public MyShoppingExceptions(BindingResult br) {
		super();
		this.br = br;
	}
}