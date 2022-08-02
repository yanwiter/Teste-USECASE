package com.ucsbr.com.prova.service.mapper;

import java.util.List;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.ucsbr.com.prova.entity.Perfil;
import com.ucsbr.com.prova.service.dto.PerfilDTO;


public interface PerfilMapper {
	PerfilMapper INSTANCE = Mappers.getMapper( PerfilMapper.class );
	@Mapping(source = "numberOfSeats", target = "seatCount")
    List<PerfilDTO> toDto(List<Perfil> entityList);
    Perfil perfil(PerfilDTO dto);
    List<Perfil> toEntity(List<PerfilDTO> dtoList);
    Perfil toEntity(PerfilDTO dto);
	PerfilDTO toDto(Perfil entity);
}
