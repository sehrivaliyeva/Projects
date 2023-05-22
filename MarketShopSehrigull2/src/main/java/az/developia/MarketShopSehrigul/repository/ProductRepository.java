package az.developia.MarketShopSehrigul.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import az.developia.MarketShopSehrigul.model.CashiersProduct;
import az.developia.MarketShopSehrigul.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

	
	
	@Query(value = "select * from products where name like %?1% or description like %?1% or price like %?1% or "
			+ "barcode like %?1% or cost like %?1% or quantity like %?1% or percent like %?1%", nativeQuery = true)
	
	public List<Product> findAllSearchAllFields(String search);

	public Optional<Product> findByBarcode(Integer barcode);

	public void deleteById(Integer id);

	public Optional<CashiersProduct> findAllByBarcode(Integer barcode);
	
	
	


    
}
