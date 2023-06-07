package az.developia.springrom.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import az.developia.springrom.model.Book;
import az.developia.springrom.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> findAll() {
		return bookRepository.findAll();
	}
	
	public void save(Book b) {
		bookRepository.save(b);
	}

	public boolean deleteById(Integer id) {
		
	Optional<Book> finded=	bookRepository.findById(id);
	if(finded.isPresent()) {
		bookRepository.deleteById(id);
		return true;
	}else {
		return false;
	}
		
		
	}

	public Book findById(Integer id) {
		
		 
		return bookRepository.findById(id).get();
	}

	public List<Book> findAllByNameContaining(String name) {
		return bookRepository.findAllByName(name);
	}

	public List<Book> findAllNameSearch(String sorgu) {
		
		return bookRepository.findAllByNameSearch(sorgu);
	}
	


	
}
