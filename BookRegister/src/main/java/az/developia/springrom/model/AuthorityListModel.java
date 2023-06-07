package az.developia.springrom.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="authority_list")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthorityListModel {
	
	@Id
	private String authority;
	

}
