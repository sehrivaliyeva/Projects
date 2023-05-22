package az.developia.MarketShopSehrigul.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.MarketShopSehrigul.model.CashiersProduct;
import az.developia.MarketShopSehrigul.model.Product;
import az.developia.MarketShopSehrigul.repository.CashiersProductRepository;
import az.developia.MarketShopSehrigul.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	 private ProductRepository productRepository;
	
	@Autowired
	 private CashiersProductRepository cashiersProductRepository;
	

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findById(Integer id) {
		 return productRepository.findById(id).get();
		
	}

	public Product save(Product product) {
		product.setRegisterDate((LocalDateTime.now()));
		product.setPercent(percent(product.getCost(),product.getPrice()));
		
		CashiersProduct cashiersProduct=new CashiersProduct();
		cashiersProduct.setId(product.getId());
		cashiersProduct.setName(product.getName());
		cashiersProduct.setBarcode(product.getBarcode());
		if(product.getAvailableQuantity() == null) {
			product.setAvailableQuantity(1.0);
		}
		
		cashiersProduct.setAvailableQuantity(product.getAvailableQuantity());
		cashiersProduct.setDescription(product.getDescription());
		cashiersProduct.setPrice(product.getPrice());
		cashiersProductRepository.save(cashiersProduct);
		 return productRepository.save(product);
		
	}

	private static Double percent(Double cost,Double price) {
		
		Double percentIlk=100*((100*(price-cost))/cost);
		Double percentSon=100*percentIlk;
		Integer p1=percentSon.intValue();
		double p=(double)(p1/100);
		
		return p/100;
	}

	
		
	

	public Product edit(Product product) {
		product.setUpdateDate((LocalDateTime.now()));
		product.setPercent(percent(product.getCost(), product.getPrice()));
		
		CashiersProduct cashiersProduct=new CashiersProduct();
		cashiersProduct.setId(product.getId());
		cashiersProduct.setName(product.getName());
		cashiersProduct.setBarcode(product.getBarcode());
		cashiersProduct.setAvailableQuantity(product.getAvailableQuantity());
		cashiersProduct.setDescription(product.getDescription());
		cashiersProduct.setPrice(product.getPrice());
		cashiersProductRepository.save(cashiersProduct);
		 
		return productRepository.save(product);
	}

	public void deleteById(Integer id) {
		productRepository.deleteById(id);
		
	}

	public List<Product> findAllSearchAllFields(String search) {
		
		return productRepository.findAllSearchAllFields(search);
	}

	public List<CashiersProduct> findAllByBarcode(Integer barcode){
		return cashiersProductRepository.findAllByBarcode(barcode);
	}

	public Optional<Product> findByBarcode(Integer barcode) {
		
		return productRepository.findByBarcode(barcode);
	}

	
	

}

