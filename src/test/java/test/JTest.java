package test;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class JTest extends AbstractWebTest {

    private static final String HEALTH = "/health";

    @Test
    public void ok() throws Exception {
        mvc.perform(get(HEALTH)
                .param("catalogCode", ""))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("UP")));
    }

}
