package az.developia.MarketShopSehrigul.DTO;

import java.math.BigInteger;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ResponseOrderDTO {
	
	
	private Double totalPrice;
	
	@CreationTimestamp
    private LocalDateTime date;
	
	private String cashier;
	
	private Integer checkId;
	 
	 
	
	


}
