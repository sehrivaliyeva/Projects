package az.developia.MarketShopSehrigul.exception;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private String field;
	private String message;

}
