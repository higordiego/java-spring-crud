package br.com.api.rest.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.api.rest.dto.UserDto;
import br.com.api.rest.models.UserModel;
import br.com.api.rest.repository.UserRepository;


@Service
public class UserService extends AbstractService {

	@Autowired
	UserRepository repository;

	public List<UserDto> listAll() {
		List<UserModel> list = (List<UserModel>) repository.findAll();
		return convertList(list, UserDto.class);
	}
	
	public UserDto listOne(Long id) {
		return convertSimple(repository.findById(id), UserDto.class );
	}
	
	public void save(UserDto user) {
		repository.save(convertSimple(user, UserModel.class));
	}
		
}
