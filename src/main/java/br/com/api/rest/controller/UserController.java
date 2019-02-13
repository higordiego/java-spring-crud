package br.com.api.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.api.rest.dto.HandlerError;
import br.com.api.rest.dto.UserDto;
import br.com.api.rest.service.UserService;

@RestController
public class UserController extends HandlerError implements WebMvcConfigurer  {

	@Autowired
	UserService service;


	@GetMapping("/api/user")
	@ResponseBody
	public ResponseEntity<?> all(Errors errors){
		if (errors.hasErrors()) {
			return ResponseEntity.badRequest().body(getFieldsErrors(errors));
		}
		return ResponseEntity.ok(service.listAll());
	}

	@PostMapping("/api/user")
	@ResponseBody
	public ResponseEntity save(@RequestBody @Valid UserDto user, Errors errors) {
		if (errors.hasErrors()) {
			return ResponseEntity.badRequest().body(getFieldsErrors(errors));
		}
		service.save(user);
		return (ResponseEntity) ResponseEntity.ok();
	}

	@GetMapping("/api/user/:id")
	public ResponseEntity<?> listOne(@PathVariable("id") @Valid Long id, Errors errors) {
		if (errors.hasErrors()) {
			return ResponseEntity.badRequest().body(getFieldsErrors(errors));
		}
		return ResponseEntity.ok(service.listOne(id));
	}

}
