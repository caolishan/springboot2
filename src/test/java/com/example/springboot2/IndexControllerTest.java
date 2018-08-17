package com.example.springboot2;

import com.example.springboot2.model.User;
import com.example.springboot2.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot2Application.class)
public class IndexControllerTest {

    @Autowired
    ApplicationContext context;
    @Autowired
    IndexController indexController;

    MockMvc mvc;

    @Before
    public void setup(){
        mvc= MockMvcBuilders.standaloneSetup(indexController).build();
    }


    @Test
    public void index() throws Exception {
        UserService userService = context.getBean(UserService.class);
        User user = new User();
        user.setName("Jack");
        userService.add(user);
        MvcResult mvcResult = mvc.perform(
                                             MockMvcRequestBuilders.get("/index")
                                            .accept(MediaType.APPLICATION_JSON_UTF8)
                                            .param("name", "jack Ma")
                                        ).andExpect(MockMvcResultMatchers.status().isOk())
                                        .andDo(MockMvcResultHandlers.print())
                                        .andReturn();

        System.out.println("output:"+mvcResult.getResponse().getContentAsString());


    }

}