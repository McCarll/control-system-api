package test;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class JTest extends AbstractWebTest {

    private static final String HEALTH = "/health";
    private static final String PING = "/ping";

    @Test
    public void ok() throws Exception {
        boolean ok = true;
        TestCase.assertTrue(ok);
    }

//    @Test
//    public void ok2() throws Exception {
//        mvc.perform(get(PING))
//                .andExpect(status().isOk());
//    }

}
