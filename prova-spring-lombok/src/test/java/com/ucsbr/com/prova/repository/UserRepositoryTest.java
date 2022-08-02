package com.ucsbr.com.prova.repository;

import com.ucsbr.com.prova.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@SpringBootTest
public class UserRepositoryTest {

  private static final String EMAIL = "samuluc1@gmail.com";
  private User u = new User();
  
  @Autowired
  UserRepository repository;

  public void setUp(){
    u.setEmail("samuluc1@gmail.com");
    u.setLogin("samuluc");
    u.setPassword("1234");
    u.setNome("Samuel Luciano de Souza");
    repository.save(u);
  }

  public void tearDown(){
    repository.deleteAll();
  }

  public void testSave(){
    User u = new User();
    u.setEmail("jhon@net.com");
    u.setLogin("jhon");
    u.setPassword("1234");
    u.setNome("Jhon Doe");

    User response = repository.save(u);

    //assertNotNull(response);

  }


  public void testFindEmail(){
    Optional<User> response = repository.findByEmailEquals(EMAIL);
    //assertTrue(response.isPresent());
    //assertEquals(response.get().getEmail(), EMAIL);
  }

  public void deleteUser(){
	setUp();
	repository.delete(u);   
    verify(repository, times(1)).delete(u); 
  }
  
  public void deleteUserByEmail(){
	setUp();	
	Optional<User> user = repository.findByEmailEquals("jhon@net.com");   
	repository.delete(user.get());   
    verify(repository, times(1)).delete(u); 
  }

}
