package br.com.api.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.rest.models.UserModel;

 
public interface UserRepository extends JpaRepository<UserModel, Long> {

	UserModel findByEmailAndPassword(String email, String password);

}
