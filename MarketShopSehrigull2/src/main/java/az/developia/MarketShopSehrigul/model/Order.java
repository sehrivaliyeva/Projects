package az.developia.MarketShopSehrigul.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String cashierName;  
	
	@CreationTimestamp
    private LocalDateTime date;

    private Double totalPrice;
	

	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL, targetEntity = ShoppingCart.class)
	
	@JoinColumn(name="order_id", referencedColumnName = "id")
	private List<ShoppingCart> cartItems;
	

	public Order(String cashierName,List<ShoppingCart> cartItems,Double totalPrice) {
		
		this.cartItems=cartItems;
		this.cashierName = cashierName;
       
        this.totalPrice = totalPrice;
	}


	 
	

}
