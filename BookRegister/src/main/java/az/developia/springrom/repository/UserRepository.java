package az.developia.springrom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springrom.model.Book;
import az.developia.springrom.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {

}
