package az.developia.MarketShopSehrigul.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.developia.MarketShopSehrigul.model.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{

}
