package az.developia.MarketShopSehrigul.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.developia.MarketShopSehrigul.exception.MyUserExceptions;
import az.developia.MarketShopSehrigul.exception.MySaveValidationException;
import az.developia.MarketShopSehrigul.model.Product;
import az.developia.MarketShopSehrigul.repository.ProductRepository;
import az.developia.MarketShopSehrigul.service.ProductService;



@RestController

@CrossOrigin(origins="*")
@RequestMapping(path="/rest/products")
public class ProductRestController {
	
	
	@Autowired
	private ProductService productService;
	
	
	
	@GetMapping
	@PreAuthorize(value = "hasAnyAuthority('admin')")
	public List<Product> findAll(){
		return productService.findAll();
	}
	
	@GetMapping(path="find/{id}")
	public Product findById(@PathVariable Integer id) {
	  return productService.findById(id);
	}
	
	
	@PostMapping(path="/add")
	@PreAuthorize(value = "hasAnyAuthority('admin')")
	public Product add(@Valid@RequestBody Product product, BindingResult br)throws Exception {
		
		if(br.hasErrors()) {
			throw new MySaveValidationException(br);
		}
		Optional<Product> barcodeOptional = productService.findByBarcode(product.getBarcode());
		if(barcodeOptional.isPresent()) {
			throw new MyUserExceptions("'" + product.getBarcode() + "' bu barcode-la məhsul artıq mövcuddur");
		} else {
		product.setId(null);
		return productService.save(product);
	}
	
	}
	@DeleteMapping(path="delete/{id}")
	@PreAuthorize(value = "hasAnyAuthority('admin')")
	public void deleteById(@PathVariable Integer id) {
		productService.deleteById(id);
	}
	
	@PutMapping(path="/edit")
	@PreAuthorize(value = "hasAnyAuthority('admin')")
	public Product edit(@Valid@RequestBody Product product,BindingResult br) throws Exception{
		if(br.hasErrors()) {
			throw new MySaveValidationException(br);
		}
		
		return productService.edit(product);
	}
	
	
	@GetMapping(path = "/search")
	@PreAuthorize(value = "hasAnyAuthority('admin')")
	public List<Product> findAllSearch(@RequestParam(name = "q", required = false, defaultValue = "") String search){
		return productService.findAllSearchAllFields(search);
	}
}