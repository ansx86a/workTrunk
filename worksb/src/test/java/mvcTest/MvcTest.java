package mvcTest;

import myspringBoot.MysbApplication;
import org.hamcrest.core.StringEndsWith;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * 參考GreetingControllerTests，裡面的test是當初不知去那抄的還不錯
 * 除了AutoConfigureMockMvc外，還有WebMvcTest,JsonTest,DataJpaTest,RestClientTests
 *
 * 參考：https://reflectoring.io/spring-boot-web-controller-test/
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MysbApplication.class)
@AutoConfigureMockMvc
public class MvcTest {


    @Autowired
    private MockMvc mvc;

    @Test
    public void test1() throws Exception {
        MvcResult mvcResult = mvc
//                .perform(MockMvcRequestBuilders.get("/greeting/{urlparam}","123"))
//                .perform(MockMvcRequestBuilders.post("/greeting")
//                        .contentType(MediaType.APPLICATION_JSON_VALUE)
//                        .content("json")
//                        .param("param1","value1")
//                )
                .perform(MockMvcRequestBuilders.get("/greeting"))
                .andExpect(status().isOk())
                // 好像lambda，只有return沒用，一定要有andExpect，而也可以不用return在andExpect就check完return data
                //.andExpect(content().string("xxxjson"))
                //.andExpect(content().string(StringEndsWith.endsWithIgnoringCase("xxxx")))
                .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println(result);
    }



}
