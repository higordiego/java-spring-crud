package br.com.api.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.rest.dto.UserDto;
import br.com.api.rest.models.UserModel;
import br.com.api.rest.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@GetMapping("/api/user")
	@ResponseBody
	public ResponseEntity<?> all() {
		return ResponseEntity.ok(service.listAll());
	}

	@PostMapping("/api/user")
	@ResponseBody
	public ResponseEntity<?> save(@RequestBody UserDto user) throws Exception {
		service.save(user);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@GetMapping("/api/user/:id?name=higor&idade=10")
	public ResponseEntity<UserDto> listOne(@RequestParam("name") String name, @RequestParam("idade") String idade,
			@PathVariable("id") Long id) {
		return ResponseEntity.ok(service.listOne(id));
	}

}
