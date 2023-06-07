package az.developia.springrom.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
	
@Id	
private	String username;
private	String password;
private Integer enabled;
	
@ManyToMany
@JoinTable(name="authorities",
joinColumns = @JoinColumn(name="username"),
inverseJoinColumns = @JoinColumn(name="authority"))

	private List<AuthorityListModel> authorities;

public void addAuthority(AuthorityListModel a) {
	if(authorities==null) {
		authorities=new ArrayList<>();
		
	}
	authorities.add(a);
}



}
