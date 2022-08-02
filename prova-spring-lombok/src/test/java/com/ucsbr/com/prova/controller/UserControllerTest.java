package com.ucsbr.com.prova.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ucsbr.com.prova.entity.User;
import com.ucsbr.com.prova.service.UserService;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

  private final String EMAIL = "james@net.com";
  private final String NAME = "James West Nunes";
  private final String PASSWORD = "1234";
  private final String LOGIN = "james";

  private final String URL = "/user";

  @MockBean
  UserService userService;

  @Autowired
  MockMvc mvc;

  public void testSave() throws Exception {
    BDDMockito.given(userService.save(Mockito.any(User.class))).willReturn(getMockUser());
    mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload())
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isCreated());
  }

  public User getMockUser(){
    User u = new User();
    u.setNome(NAME);
    u.setPassword(PASSWORD);
    u.setEmail(EMAIL);
    u.setLogin(LOGIN);
    return u;
  }

  public String getJsonPayload() throws JsonProcessingException {
    User dto = new User();
    dto.setNome(NAME);
    dto.setEmail(EMAIL);
    dto.setLogin(LOGIN);

    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(dto);

  }
  
  public String delete() throws JsonProcessingException {
	    User dto = new User();
	    dto.setNome(NAME);
	    dto.setEmail(EMAIL);
	    dto.setLogin(LOGIN);
	    ObjectMapper mapper = new ObjectMapper();
	    return mapper.writeValueAsString(dto);

	  }

}
