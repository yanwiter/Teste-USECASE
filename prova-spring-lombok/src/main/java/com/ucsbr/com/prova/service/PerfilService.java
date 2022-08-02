package com.ucsbr.com.prova.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ucsbr.com.prova.entity.Perfil;
import com.ucsbr.com.prova.repository.PerfilRepository;
import com.ucsbr.com.prova.service.dto.PerfilDTO;
import com.ucsbr.com.prova.service.mapper.PerfilMapper;


@Service
public class PerfilService {

	private final PerfilRepository perfilRepository;

	PerfilService(PerfilRepository perfilRepository) {
		this.perfilRepository = perfilRepository;
	}

	public List<Perfil> ListarPerfis() {
		return perfilRepository.findAll();					
	}
	
	@SuppressWarnings("deprecation")
	public Perfil getById(long id) {
		return perfilRepository.getById(id);			
	}

	public void DeleteById(long id) {
		 perfilRepository.deleteById(id);					
	}
	
	@SuppressWarnings("deprecation")
	public PerfilDTO Update(PerfilDTO perfilDTO) {
			Perfil perfil = perfilRepository.getById(perfilDTO.getIdPerfil());
		    if (perfil != null) {
		    	Perfil entity = PerfilMapper.INSTANCE.toEntity(perfilDTO);
		    	perfilRepository.save(entity);
		      return perfilDTO;
		    } else {
		      return new PerfilDTO();
		    }
		  }
	  
	public PerfilDTO salvarPerfil(PerfilDTO perfilDTO) {
		Perfil perfil = toEntity(perfilDTO);
		return toDTO(perfilRepository.save(perfil));
	}
	
	@SuppressWarnings("static-access")
	public Perfil toEntity(PerfilDTO perfilDTO) {
		Perfil perfil = new Perfil();
		perfil.setEndereco(perfilDTO.getEndereco());
		perfil.setBairro(perfilDTO.getBairro());
		perfil.setTipo(perfilDTO.getTipo().START);
		return perfil;
	}

	@SuppressWarnings("static-access")
	public PerfilDTO toDTO(Perfil perfil) {
		PerfilDTO perfil1 = new PerfilDTO();
		perfil1.setEndereco(perfil1.getEndereco());
		perfil1.setBairro(perfil1.getBairro());
		perfil1.setTipo(perfil1.getTipo().START);
		return perfil1;

	}

}
