package az.developia.MarketShopSehrigul.DTO;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFilter;

import az.developia.MarketShopSehrigul.model.ShoppingCart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class OrderDTO {
	
	private List<ShoppingCart> cartItems;
	private String cashierName;
	

}
