package com.ucsbr.com.prova.webrest;
import java.util.List;

import com.ucsbr.com.prova.entity.Perfil;
import com.ucsbr.com.prova.entity.User;
import com.ucsbr.com.prova.service.UserService;
import com.ucsbr.com.prova.service.dto.PerfilDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@ApiOperation("Usuários")
public class UserController {

  private final UserService userService;
  private final PasswordEncoder encoder;

  public UserController(UserService userService, PasswordEncoder encoder) {
    this.userService = userService;      
    this.encoder = encoder;
  }
  
  @ApiOperation(value = "Cria um novo usuário")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Usuário Criado"),
      @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
      @ApiResponse(code = 500, message = "Foi gerada uma exceção")
  })
  
  
  @PostMapping("/salvar")
  public ResponseEntity<User> create(@RequestBody User user) {
	user.setPassword(encoder.encode(user.getPassword()));
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
  }
  
  @GetMapping("/listarTodos")
  @CrossOrigin(origins = "http://localhost:4200")
  public ResponseEntity<List<User>> listarTodos() {
      return ResponseEntity.ok(userService.findAll());
  }

  @PostMapping("/login")
  @CrossOrigin(origins = "http://localhost:4200")
  public ResponseEntity<User> salvar(@RequestBody User user) {
	  user.setPassword(encoder.encode(user.getPassword()));
      return ResponseEntity.ok(userService.save(user));
  }

  @GetMapping("/validarSenha")
  @CrossOrigin(origins = "http://localhost:4200")
  public ResponseEntity<Boolean> validarSenha(
		  @RequestParam String login,
          @RequestParam String password) {
	  User user = userService.getUserByUsername(login);
      if (user == null) {
          return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
      }
      boolean valid = encoder.matches(password, user.getPassword());
      HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
      return ResponseEntity.status(status).body(valid);
  }
  
	@DeleteMapping("/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
		try {
			userService.DeleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteByEmail/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("email") String email) {
		try {
			userService.DeleteByEmail(email);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	 * @PutMapping("/updateUser/{id}") public ResponseEntity<User>
	 * updatePerfil(@PathVariable("id") long id, @RequestBody User user) { User user
	 * = userService.getById(id); if (user != null) { User user =
	 * userService.Update(user); return new ResponseEntity<>(user, HttpStatus.OK); }
	 * else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 */

}
