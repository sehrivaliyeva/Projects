package az.developia.MarketShopSehrigul.service;

 
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import az.developia.MarketShopSehrigul.DTO.OrderDTO;
import az.developia.MarketShopSehrigul.model.CashiersProduct;
import az.developia.MarketShopSehrigul.model.Order;
import az.developia.MarketShopSehrigul.model.Product;
import az.developia.MarketShopSehrigul.model.ShoppingCart;
import az.developia.MarketShopSehrigul.repository.CashiersProductRepository;
import az.developia.MarketShopSehrigul.repository.OrderRepository;
import az.developia.MarketShopSehrigul.repository.ProductRepository;

@Service
public class OrderService {
	

@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	 private CashiersProductRepository cashiersProductRepository;
	
	
    public List<Order> findAll() {
		
		return orderRepository.findAll();
	}
	

    
     
     public Double getCartAmount(List<ShoppingCart> shoppingCartList) {
    	 
    	 Double totalPrice=0d;
    	 Double productTotalPrice=0d;
    	 double availableQuantity=0;
    	 
    	 for(ShoppingCart cart: shoppingCartList) {
    		 
    		 Integer  productBarcode =cart.getProductBarcode();
    		 Optional<Product> product=productRepository.findByBarcode(productBarcode);
    		 Optional<CashiersProduct> forCashier=cashiersProductRepository.findByBarcode(productBarcode);
    		 if(product.isPresent()&& forCashier.isPresent()) {
    			 Product product1=product.get();
    			 CashiersProduct forCashiers=forCashier.get();
    			 if(product1.getAvailableQuantity()<
    					 cart.getProductSaleQuantity()) {
    				 
    				 productTotalPrice=product1.getPrice()*
    						 product1.getAvailableQuantity();
    				 cart.setProductSaleQuantity(product1.getAvailableQuantity());
    				 
    			                          }else{
    			                  productTotalPrice=
    			                  cart.getProductSaleQuantity()*product1.getPrice();
    			                  availableQuantity=product1.getAvailableQuantity()-cart.getProductSaleQuantity();
    			                        	  
    			                          }
    			 
    			 totalPrice=totalPrice+productTotalPrice;
    			 product1.setAvailableQuantity(availableQuantity);
    			 forCashiers.setAvailableQuantity(availableQuantity);
    			 availableQuantity=0;
    			 cart.setProductBarcode(product1.getBarcode());
    			 cart.setProductPrice(product1.getPrice());
    			 cart.setProductName(product1.getName());
    			 cart.setProductTotalPrice(productTotalPrice);
    			 
    			 productRepository.save(product1);
    		 }
    	 }
    	 
    	return totalPrice; 
     }

	public Order saveOrder(Order order) {
		
		return orderRepository.save(order);
		}

	
	}
	

	



