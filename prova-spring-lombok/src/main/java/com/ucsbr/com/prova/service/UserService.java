package com.ucsbr.com.prova.service;

import com.ucsbr.com.prova.data.DetalheUserData;
import com.ucsbr.com.prova.entity.Perfil;
import com.ucsbr.com.prova.entity.User;
import com.ucsbr.com.prova.repository.UserRepository;
import com.ucsbr.com.prova.service.dto.PerfilDTO;
import com.ucsbr.com.prova.service.dto.UserDTO;
import com.ucsbr.com.prova.service.mapper.PerfilMapper;
import com.ucsbr.com.prova.service.mapper.UserMapper;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@ComponentScan
@Service
public class UserService implements UserDetailsService {
	
	private final UserRepository userRepository;

	UserService(UserRepository userRepository) { 
		this.userRepository = userRepository;
	}
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> usuario = userRepository.findByLogin(username);
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
        }
        return new DetalheUserData(usuario);
    }

	public User findByEmail(String email) {
		return this.userRepository.findByEmailEquals(email).get();
	}
	
	public List<User> findAll() {
		return this.userRepository.findAll();
	}
	
	public Boolean Login(String password, String login) {
		var user = this.userRepository.findByLogin(login).get();
		if(user.getPassword() == password) {
			return true;
		}
		return false;	
	}

	public User save(User user) {
		return this.userRepository.save(user);
	}
	
	public User getUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> usuario = userRepository.findByLogin(username);
		if (usuario.isEmpty()) {
			return null;
		}
		return usuario.get();
	}
	
	public void DeleteById(long id) {
		 userRepository.deleteById(id);					
	}
	
	public void DeleteByEmail(String email) {
        Optional<User> usuario = userRepository.findByLogin(email);
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuário [" + email + "] não encontrado");
        }
		userRepository.deleteById(usuario.get().getId());					
	}
	
	@SuppressWarnings("deprecation")
	public User getById(long id) {
		return userRepository.getById(id);			
	}
	
	/*
	 * @SuppressWarnings("deprecation") public User Update(User user) { User user =
	 * userRepository.getById(user.getId()); if (user != null) { user entity =
	 * userMapper.INSTANCE.toEntity(user); userRepository.save(entity); return user;
	 * } else { return new PerfilDTO(); } }
	 */
}
