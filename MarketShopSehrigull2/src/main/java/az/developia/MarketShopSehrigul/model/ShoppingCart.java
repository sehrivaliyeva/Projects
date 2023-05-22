package az.developia.MarketShopSehrigul.model;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import az.developia.MarketShopSehrigul.repository.ProductRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name="shoppingcart")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShoppingCart {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "Satilan məhsulun barcode-u düzgün əlavə olmalıdır")
	private Integer productBarcode;
	
	//private Integer productId;
	
	private String productName;
	
	private Double productPrice;
    
	@NotNull(message = "Satilan məhsulun sayı olmalıdır")
    @Min(value = (long) 0.1, message = "Satılan məhsulun miqdarı 0 və ya mənfi olmamalıdır")
	private Double productSaleQuantity;
	
	private Double productTotalPrice;
	
	public ShoppingCart(String productName,Double productSaleQuantity,Double productTotalPrice
			) {
		
		
        this.productName = productName;
        this.productSaleQuantity = productSaleQuantity;
        this.productTotalPrice = productTotalPrice;
	}
	
	public ShoppingCart(Double productSaleQuantity) {
	   
	   this.productSaleQuantity=productSaleQuantity;
	}
	

	


	
	
	
	
	
	
	
	
	

}
