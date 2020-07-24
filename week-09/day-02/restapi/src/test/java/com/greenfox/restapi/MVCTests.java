package com.greenfox.restapi;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import com.greenfox.restapi.controllers.RawController;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(RawController.class)
@AutoConfigureMockMvc
public class MVCTests {

  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(),
      StandardCharsets.UTF_8);

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void doublingGetsNoValue() throws Exception {
    mockMvc.perform(get("/doubling"))
        .andExpect(status().isOk())
        .andExpect(content().json("{\"error\": \"Please provide an input!\"}"));
  }

  @Test
  public void doublingGetsInput5() throws Exception {
    mockMvc.perform(get("/doubling?input=5"))
        .andExpect(status().isOk())
        .andExpect(content().json("{\"received\":5,\"result\":10}"));
  }

  @Test
  public void greeterGetsNoValue() throws Exception {
    mockMvc.perform(get("/greeter"))
        .andExpect(status().is(400))
        .andExpect(content().json("{\"error\":\"Please provide a name and a title!\"}"));
  }

  @Test
  public void greeterGetsOnlyNameValue() throws Exception {
    mockMvc.perform(get("/greeter?name=Vader"))
        .andExpect(status().is(400))
        .andExpect(content().json("{\"error\":\"Please provide a title!\"}"));
  }

  @Test
  public void greeterGetsBothValues() throws Exception {
    mockMvc.perform(get("/greeter?name=Vader&title=Sith"))
        .andExpect(status().isOk())
        .andExpect(content().json("{\"welcome_message\":\"Oh, hi there Vader, my dear Sith!\"}"));
  }

  @Test
  public void appendaGetsCorrentValue() throws Exception {
    mockMvc.perform(get("/appenda/kuty"))
        .andExpect(status().isOk())
        .andExpect(content().json("{\"appended\":\"kutya\"}"));
  }

  @Test
  public void appendaGetsNoValue() throws Exception {
    mockMvc.perform(get("/appenda"))
//        .contentType(MediaType.APPLICATION_JSON)
        .andExpect(status().is(404))
        .andExpect(jsonPath("$").doesNotExist());
//        .andExpect(content().json("{\"timestamp\":\"2020-07-23T15:19:30.823+00:00\",\"status\":404,\"error\":\"Not Found\",\"message\":\"No message available\",\"path\":\"/appenda\"}"));
//        .andExpect(content().contentType(contentType))
//        .andExpect(jsonPath("$.error", is("Not Found")));
  }
}
