package az.developia.springrom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import az.developia.springrom.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	List<Book> findAllByName(String n);
	
	
	

	@Query(value="select * from books where name like %?1%",nativeQuery=true)
	
	List<Book> findAllByNameSearch(String n);

	
	

	// 150,50
	@Query(value = "select * from books limit ?1,?2",nativeQuery = true)
	List<Book> findAllPartial (Integer begin,Integer length);


	

}
