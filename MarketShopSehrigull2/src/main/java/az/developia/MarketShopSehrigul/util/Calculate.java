package az.developia.MarketShopSehrigul.util;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import az.developia.MarketShopSehrigul.model.Product;
@Component
public class Calculate {
	
	//@Autowired
	//Product product;
	
	public LocalDateTime dateCalculate(){
		LocalDateTime localdate=LocalDateTime.now();
		return localdate;
		
	}
	
	public Double percentCalculate(Double price,Double cost) {
		
	Double percent1=(price*100)/cost-100;
		return percent1;
	}

}
