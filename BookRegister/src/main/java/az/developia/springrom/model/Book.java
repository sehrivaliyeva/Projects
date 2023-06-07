package az.developia.springrom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;



import java.sql.Date;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private Integer id;

	@NotNull
	@NotEmpty(message = "Bos qoymaq olmaz")
	@Size(min = 2, message = "kitab adi minimum 2 simvol olmalidir")
	@Size(max = 45, message = "kitab adi maksimum 45 simvol olmalidir")


	private String name;
	

	@Min(value = 1, message = "qiymet min 1 olmalidir")
	@Max(value = 1000, message = "qiymet mak 1000 olmalidir")
	@NotNull(message = "qiymet mutleqdir")
	private Double price;

	@Past
	private Date publishDate;
	private String language;
	
	
	@ManyToMany
private List<Author> authors;

	
}

