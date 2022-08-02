package com.ucsbr.com.prova.webrest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ucsbr.com.prova.entity.Perfil;
import com.ucsbr.com.prova.service.PerfilService;
import com.ucsbr.com.prova.service.dto.PerfilDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/perfil")
@ApiOperation("perfil")
public class PerfilController {

	private final PerfilService perfilService;

	public PerfilController (PerfilService perfilService) {
		this.perfilService = perfilService;
	}

	@ApiOperation(value = "Crie um novo perfil")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Perfil criado"),
			@ApiResponse(code = 403, message = "Você não tem permisão"),
			@ApiResponse(code = 500, message = "Foi gerado uma exeção") })

	
	@PostMapping
	public ResponseEntity<PerfilDTO> create(PerfilDTO perfilDTO) {
		PerfilDTO perfil = perfilService.salvarPerfil(perfilDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(perfil);
	}

	@GetMapping()
	public List<Perfil> ListarPerfis() {
		return perfilService.ListarPerfis();
	}
	
	@PutMapping("/perfis/{id}")
	public ResponseEntity<PerfilDTO> updatePerfil(@PathVariable("id") long id, @RequestBody PerfilDTO perfilDTO) {
		   Perfil perfil = perfilService.getById(id);
	    if (perfil != null) {
	    	PerfilDTO dto = perfilService.Update(perfilDTO);
	      return new ResponseEntity<>(dto, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	@DeleteMapping("/perfil/{id}")
	public ResponseEntity<HttpStatus> deletePerfil(@PathVariable("id") long id) {
		try {
			perfilService.DeleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
