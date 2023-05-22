package az.developia.MarketShopSehrigul.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import az.developia.MarketShopSehrigul.model.CashiersProduct;
@Repository
public interface CashiersProductRepository extends JpaRepository<CashiersProduct, Integer> {
	
	public Optional<CashiersProduct> findByBarcode(Integer barcode);
	
	
	
	@Query(value = "select * from cashier_product  where barcode like %?1%", nativeQuery = true)
	public List<CashiersProduct> findAllByBarcode(Integer barcode);
	

}
