package fizzbuzzforalfresco.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import fizzbuzzforalfresco.demo.dto.Range;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class FizzBuzzRESTControllerTest {
    public static final String FIRST_SOLUTION_RESULT = "1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz";
    public static final String SECOND_SOLUTION_RESULT = "1 2 alfresco 4 buzz fizz 7 8 fizz buzz 11 fizz alfresco 14 fizzbuzz 16 17 fizz 19 buzz";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void firstSolution_Success() throws Exception {
        String url = "/firstSolution";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post(url)
                .content(asJsonString(new Range(1, 20)))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        assertEquals(mvcResult.getResponse().getStatus(), 200);
        assertEquals(mvcResult.getResponse().getContentAsString(), FIRST_SOLUTION_RESULT);
    }

    @Test
    public void secondSolution_Success() throws Exception {
        String url = "/secondSolution";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post(url)
                .content(asJsonString(new Range(1, 20)))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        assertEquals(mvcResult.getResponse().getStatus(), 200);
        assertEquals(mvcResult.getResponse().getContentAsString(), SECOND_SOLUTION_RESULT);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
