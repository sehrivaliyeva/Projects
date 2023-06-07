package az.developia.springrom.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.springrom.model.AuthorityListModel;
//import az.developia.springrom.model.AuthorityModel;
import az.developia.springrom.model.UserModel;
import az.developia.springrom.repository.AuthorityListRepository;
//import az.developia.springrom.repository.AuthorityRepository;
import az.developia.springrom.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private AuthorityListRepository authorityListRepository;
	
	
	public void saveUser( UserModel user) {
		
		user.setPassword("{noop}"+user.getPassword());
		
		user.setEnabled(1);
		
		
		AuthorityListModel a=authorityListRepository.findById("books:get:all").get();
		
				user.addAuthority(a);
		
		        repository.save(user);
	}


	public List<UserModel> findAll() {
		
		return repository.findAll();
	}


	

	
	
	
	

}
