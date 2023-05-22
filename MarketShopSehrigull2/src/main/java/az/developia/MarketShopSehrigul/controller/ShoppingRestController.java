package az.developia.MarketShopSehrigul.controller;



import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import az.developia.MarketShopSehrigul.DTO.OrderDTO;
import az.developia.MarketShopSehrigul.DTO.ResponseOrderDTO;
import az.developia.MarketShopSehrigul.exception.MySaveValidationException;
import az.developia.MarketShopSehrigul.model.CashiersProduct;
import az.developia.MarketShopSehrigul.model.Order;
import az.developia.MarketShopSehrigul.model.Product;
import az.developia.MarketShopSehrigul.model.ShoppingCart;
import az.developia.MarketShopSehrigul.repository.OrderRepository;


import az.developia.MarketShopSehrigul.service.OrderService;
import az.developia.MarketShopSehrigul.service.ProductService;
import az.developia.MarketShopSehrigul.service.ShoppingCartService;
import az.developia.MarketShopSehrigul.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="rest/shopping")

public class ShoppingRestController {
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
    private ProductService productService;
	
	@Autowired
	 private ShoppingCartService shoppingCartService;
	
	@GetMapping(path="/orders")
	@PreAuthorize(value = "hasAnyAuthority('admin')")
	public List<Order> findAllOrder(){
		return orderService.findAll();
	}
	

	@GetMapping(path="/carts")
	@PreAuthorize(value = "hasAnyAuthority('admin')")
	public List<ShoppingCart> findAllCarts(){
		
		return shoppingCartService.findAll();
	}

	@GetMapping(path="/find-by-barcode")
	@PreAuthorize(value = "hasAnyAuthority('cashier')")
	public List<CashiersProduct> searchByBarcode(@RequestParam(name = "barcode", required = false, defaultValue = "") Integer barcode) {
		return productService.findAllByBarcode(barcode);
	}
	
	
	@PostMapping(path="/save-order")
	@PreAuthorize(value = "hasAnyAuthority('cashier')")
	public ResponseEntity<ResponseOrderDTO> saveOrder(@Valid@RequestBody OrderDTO orderDTO, BindingResult br){
		if(br.hasErrors()) {
			throw new MySaveValidationException(br);
		}
		
		String loggedInUsername = SecurityContextHolder.getContext().getAuthentication().getName();
	
		ResponseOrderDTO responseOrderDTO=new ResponseOrderDTO();
	  Double totalPrice=orderService.getCartAmount(orderDTO.getCartItems());
	
	  Order order =new Order(loggedInUsername,orderDTO.getCartItems(),
			totalPrice);
	order=orderService.saveOrder(order);
	
	responseOrderDTO.setTotalPrice(totalPrice);
	responseOrderDTO.setDate(order.getDate());
	responseOrderDTO.setCheckId(order.getId());
	responseOrderDTO.setCashier(loggedInUsername);
	
	 return ResponseEntity.ok(responseOrderDTO);
}
	@PostMapping(path = "/save-cart")
	@PreAuthorize(value = "hasAnyAuthority('cashier')")
	public ShoppingCart saveBasket(@RequestBody ShoppingCart cart) {
		return shoppingCartService.save(cart);
	}
	

	@GetMapping(path = "/search-dates")
	@PreAuthorize(value = "hasAnyAuthority('admin')")
	List<Object> findByMyDateCarts(@RequestParam("startDate") String startDateString,
			@RequestParam("endDate") String endDateString) {
		
		Timestamp startDate = Timestamp.valueOf(startDateString);
		Timestamp endDate = Timestamp.valueOf(endDateString);
		return orderRepository.findByDateCarts(startDate, endDate);
	}	

}