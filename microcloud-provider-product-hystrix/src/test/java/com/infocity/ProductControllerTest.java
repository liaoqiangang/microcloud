package com.infocity;

import com.infocity.controller.ProductController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author liaoqiangang
 * @date 2020/3/18 5:21 PM
 * @desc
 * @lastModifier
 * @lastModifyTime
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProductHystrixApp.class)
@WebAppConfiguration
public class ProductControllerTest {

  private MockMvc mvc;

  @Before
  public void setUp() throws Exception {
    mvc = MockMvcBuilders.standaloneSetup(new ProductController()).build();
  }

  @Test
  public void hello() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/product/hello").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().string(equalTo("Hello World")));
  }
}
