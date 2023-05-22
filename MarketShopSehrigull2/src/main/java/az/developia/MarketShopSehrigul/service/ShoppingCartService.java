package az.developia.MarketShopSehrigul.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.MarketShopSehrigul.model.Product;
import az.developia.MarketShopSehrigul.model.ShoppingCart;
import az.developia.MarketShopSehrigul.repository.ProductRepository;
import az.developia.MarketShopSehrigul.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	public List<ShoppingCart> findAll() {
		
		return shoppingCartRepository.findAll();
	}
	
	
	public ShoppingCart save(ShoppingCart shoppingCart) {
		
		List<Product> products = productRepository.findAll();
		ShoppingCart cart=new ShoppingCart();
		List<ShoppingCart> shopping=new ArrayList<>();
		for(Product product1:products) {
			if(shoppingCart.getProductBarcode().equals(product1.getBarcode())) {
				cart.setProductBarcode(product1.getBarcode());
				//cart.setProductId(product1.getId());
				cart.setProductName(product1.getName());
				cart.setProductPrice(product1.getPrice());
				cart.setProductSaleQuantity(shoppingCart.getProductSaleQuantity());
				if(cart.getProductSaleQuantity()>product1.getAvailableQuantity()) {
					cart.setProductTotalPrice(product1.getPrice()*product1.getAvailableQuantity());
					cart.setProductSaleQuantity(product1.getAvailableQuantity());
					product1.setAvailableQuantity(0.0);
					
				}else {
					cart.setProductTotalPrice(product1.getPrice()*shoppingCart.getProductSaleQuantity());
					product1.setAvailableQuantity(product1.getAvailableQuantity()-shoppingCart.getProductSaleQuantity());
					
				}
				break;
				
			}
		}
		shopping.add(cart);
		
		return shoppingCartRepository.save(cart);
	}

}
