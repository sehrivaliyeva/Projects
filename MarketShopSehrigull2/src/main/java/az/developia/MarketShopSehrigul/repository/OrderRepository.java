package az.developia.MarketShopSehrigul.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import az.developia.MarketShopSehrigul.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>  {
	

	@Query(value = "select * from orders where date between ?1 and ?2", nativeQuery = true)
	List<Order> findByDateBetween(Timestamp startDate, Timestamp endDate);

	@Query(value = "select "
			+ "'kassir' || ': ' || x.cashier_name, "
			+ "'məhsulun adi' || ': ' || y.product_name, "
			+ "'mahsulun barkodu' || ': ' || y.product_barcode, "
			+ "'məhsulun qiyməti' || ': ' || y.product_price,  "
			+ "'satilan məhsulun sayi' || ': ' || sum(y.product_sale_quantity), "		
			+ "'satilan məhsulun ümumi qiyməti' || ': ' || sum(y.product_total_price) + 0.001, "
			+ "'məhsulun satıldığı çek sayı' || ': ' || count(y.order_id) "
			+ "from shoppingcart y "
			+ "join orders x on x.id=y.order_id "
			+ "where x.date between ?1 and ?2 "
			+ "group by y.product_barcode, "
			+ "y.product_price, "
			+ "y.product_name, "
			+ "x.cashier_name", nativeQuery = true)
	
	
	List<Object> findByDateCarts( Timestamp startDate, Timestamp endDate);

}


