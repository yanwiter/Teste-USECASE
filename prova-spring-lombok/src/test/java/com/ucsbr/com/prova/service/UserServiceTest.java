package com.ucsbr.com.prova.service;

import com.ucsbr.com.prova.entity.User;
import com.ucsbr.com.prova.repository.UserRepository;
import com.ucsbr.com.prova.service.dto.UserDTO;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceTest {

  @MockBean
  UserRepository userRepository;

  @Autowired
  UserService service;


  public void setUp(){
    BDDMockito.given(userRepository.findByEmailEquals(Mockito.anyString())).willReturn(Optional.of(new User()));
  }

  public void testFindByEmail() {
    User user = service.findByEmail("email@test.com");
    assertTrue(user != null);
  }

}
