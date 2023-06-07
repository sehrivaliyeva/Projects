package az.developia.springrom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.developia.springrom.model.Author;
import az.developia.springrom.model.AuthorityListModel;
import az.developia.springrom.model.Book;
import az.developia.springrom.model.UserModel;

public interface AuthorityListRepository extends JpaRepository<AuthorityListModel,String> {

	
	

}
