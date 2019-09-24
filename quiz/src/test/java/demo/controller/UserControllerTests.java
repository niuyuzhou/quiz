package demo.controller;

import demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The type User controller tests.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Name is null test.
     * @throws Exception the exception
     */
    @Test
    public void nameIsNullTest() throws Exception {
        User user = new User((long) 0.0,null);
        this.mockMvc.perform(post("/user").content(String.valueOf(user))).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content.number").value(0));
    }

    /**
     * Request body is null test.
     * @throws Exception the exception
     */
    @Test
    public void requestBodyIsNullTest() throws Exception {
        User user = null;
        this.mockMvc.perform(post("/user").content(String.valueOf(user))).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content.number").value(0));
    }
}
