package com.greenfox.restapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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
}
