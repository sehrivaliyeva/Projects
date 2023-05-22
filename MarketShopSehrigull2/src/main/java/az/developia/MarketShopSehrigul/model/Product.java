package az.developia.MarketShopSehrigul.model;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Product {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
 private Integer id;
 
 @NotNull(message="Bosh qoymaq olmaz !!")
 @NotEmpty(message="Bosh qoymaq olmaz !!")
 @Size(min=2, max=25, message=" min 2 max 30 simvol olmalidir !!")
 private String name;
 
    @NotNull(message = " boş qoymaq olmaz !!!")
	@Min(message = " Barcode-nin qarşisina '-' yazmaq olmaz, yəni barcode mənfi ola bilməz və barcode maksimum 13 rəqəmli olmalıdır", value = 0)
	@Max(value = 9999999999999L, message = " Barcode-nin qarşisina '-' yazmaq olmaz, yəni barcode mənfi ola bilməz və barcode maksimum 13 rəqəmli olmalıdır")
 private Integer barcode;
 
    @NotNull(message = " Qiyməti boş qoymaq olmaz")
	@Min(message = "Qiymət minimum 0.10 azn olmalıdır", value = (long) 0.1)
 private Double price;
 
    @Min(message = " Maya dəyəri minimum 0.10 azn olmalıdır", value = (long) 0.1)
 private Double cost;
 
 private String description;
 
 private LocalDateTime registerDate;
 
 private LocalDateTime updateDate;
 
 
 @Min(message = "Məhsulun  miqdarı minimum 0 ola bilər. Mənfi sayda məhsul ola bilməz", value = 0)
 private Double availableQuantity;
 
 
 @Min(message = "Məhsulun cost-u (maya dəyəri) price-dan (satış qiyməti)-dən az olmamalıdır", value = (long)0.1)
 private Double percent;	

 
 

	
}
 
 
 
 



