
package az.developia.springrom.controller;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import az.developia.springrom.model.Author;
import az.developia.springrom.model.Book;
import az.developia.springrom.repository.AuthorRepository;
import az.developia.springrom.service.BookService;

@Controller
@RequestMapping(path = "/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorRepository authorRepository;

	ArrayList<String> languages = new ArrayList<>();
	

	@PostConstruct
	private void init() {

		languages.add("Azərbaycan");
		languages.add("İngilis");
		languages.add("Alman");
		languages.add("Türk");
		languages.add("Fransız");
		
		
		
	}

	@GetMapping
	@PreAuthorize(value = "hasAuthority('books:get:all')")
	

	public String showBooks(Model m) {
		 
		List<Book> books = bookService.findAll();
		
	
		m.addAttribute("books", books);
		
		
		return "books";
	}

	@GetMapping(path = "/search")
	@PreAuthorize(value = "hasAuthority('books:search')")
	public String showBooksSearch(Model m,
			@RequestParam(name = "q", required = false, defaultValue = "") String sorgu) {
		
		List<Book> books = bookService.findAllNameSearch (sorgu);
		m.addAttribute("books", books);
		
		return "books";
	}

	@GetMapping(path = "/open-save-page")
	@PreAuthorize(value = "hasAuthority('books:open:add')")
	public String openSavePage(Model m) {
		Book b = new Book();
		b.setPublishDate(Date.valueOf(LocalDate.now()));
		m.addAttribute("book", b);
		m.addAttribute("languages", languages);

		m.addAttribute("authorsList", authorRepository.findAll());
		return "save-book";
	}

	@PostMapping(path = "/save") // books/save
	@PreAuthorize(value = "hasAuthority('books:save')")
	
	

	public String saveBook(@Valid @ModelAttribute(name = "book") Book b, BindingResult br, Model m) {

		if (br.hasErrors()) {
			m.addAttribute("languages", languages);

			m.addAttribute("authorsList", authorRepository.findAll());
			return "save-book";
		}
		
		 
		bookService.save(b);

		return "redirect:/books";
	}

	@GetMapping(path = "/delete/{id}") // /books/delete/20
	@PreAuthorize(value = "hasAuthority('books:delete:by:id')")
	
	

	public String delete(@PathVariable Integer id,Model m) {
		boolean result=bookService.deleteById(id);
		if(!result) {
			m.addAttribute("message", "bu id tapilmadi, id="+id);
			
			return "my-message";
		}
		return "redirect:/books";
	}

	@GetMapping(path = "/edit/{id}") // books/edit/20
	@PreAuthorize(value = "hasAuthority('books:open:edit')")
	

	public String edit(@PathVariable Integer id, Model m) {

		// bu id li kitabi bazadan gedir
		// bu kitabi modele yerlesdir
		// save sehifesini ac

		Book findedBook = bookService.findById(id);
		if (findedBook == null) {
			System.out.println("book tapilmadi");
			return "home";
		}

		m.addAttribute("book", findedBook);
		m.addAttribute("languages", languages);
		m.addAttribute("authorsList", authorRepository.findAll());
		return "save-book";
	}
	
	

	@InitBinder
	private void trim(WebDataBinder binder) {
		
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, editor);
		

	}
	
	

}