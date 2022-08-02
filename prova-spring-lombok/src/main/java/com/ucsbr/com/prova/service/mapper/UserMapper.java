package com.ucsbr.com.prova.service.mapper;

import com.ucsbr.com.prova.entity.User;
import com.ucsbr.com.prova.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/*@Mapper(componentModel = "spring", uses = {})
	public interface UserMapper extends EntityMapper<UserDTO, User>{
}
*/

@Mapper
public interface UserMapper {	
	UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );	
	
	/*
	 * @Mapping(source = "numberOfSeats", target = "seatCount") List<UserDTO>
	 * toDto(List<User> entityList);
	 * 
	 * @Mapping(source = "numberOfSeats", target = "seatCount") List<User>
	 * toEntity(List<UserDTO> dtoList);
	 * 
	 * 
	 */
	
	 User toEntity(UserDTO dto);
     UserDTO toDto(User entity);
}
