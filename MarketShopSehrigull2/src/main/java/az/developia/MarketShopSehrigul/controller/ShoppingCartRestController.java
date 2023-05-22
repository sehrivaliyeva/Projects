package az.developia.MarketShopSehrigul.controller;



import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.MarketShopSehrigul.DTO.OrderDTO;
import az.developia.MarketShopSehrigul.model.Order;
import az.developia.MarketShopSehrigul.model.Product;
import az.developia.MarketShopSehrigul.service.OrderService;
import az.developia.MarketShopSehrigul.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping(path="rest/shopping")
@Component
public class ShoppingCartRestController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
    private ProductService productService;
	
	@Autowired
	Product product;
	 
	
	
	
	
	public ShoppingCartRestController(OrderService orderService, ProductService productService) {
		
		this.orderService = orderService;
		this.productService = productService;
}
	

	@GetMapping(value="/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts(){
		 
		List<Product> productList=productService.findAll();
		
		return ResponseEntity.ok(productList);
	}

	@GetMapping("/getOrder/{orderId}")
	public ResponseEntity<Order> getOrderDetails(@PathVariable int orderId){
		Order order=orderService.getOrderDetail(orderId);
		return ResponseEntity.ok(order);
	}
	
	@PostMapping("/placeOrder")
	public ResponseEntity<ResponseOrderDTO> placeOrder(@RequestBody OrderDTO orderDTO){
	
	ResponseOrderDTO responseOrderDTO=new ResponseOrderDTO();
	Double saleAmount=orderService.getCartAmount(orderDTO.getCartItems());
	
	Order order =new Order(orderDTO.getCartItems());
	order=orderService.saveOrder(order);
	
	responseOrderDTO.setAmount(saleAmount);
	//responseOrderDTO.setDate(Date.getCurrentDataTime());
	responseOrderDTO.setInvoiceNumber(new Random().nextInt(1000));
	responseOrderDTO.setOrderId(order.getId());
	
	 return ResponseEntity.ok(responseOrderDTO);
}
}