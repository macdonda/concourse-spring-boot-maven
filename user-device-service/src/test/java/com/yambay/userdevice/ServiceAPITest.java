package com.yambay.userdevice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ServiceAPI.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
@TestPropertySource(properties = "eureka.client.enabled=false")

/**
 * Created by Alan on 5/10/2016.
 */
public class ServiceAPITest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Before
    public void setup() {

        try {
            given(this.userService.getUserId("ERP_ALANY")).willReturn("ALANY");

        } catch (Exception ex) {

        }

        try {
            given(this.userService.getExternalUserId("ALANY")).willReturn("ERP_ALANY");

        } catch (Exception ex) {

        }
    }

    @Test
    public void getExternalUserId() throws Exception {
        this.mockMvc.perform(get("/user/ALANY/getExternalUserIdFromUserId").accept(MediaType.TEXT_PLAIN))
                .andExpect(content().string("ERP_ALANY"))
                .andExpect(status().isOk())
                .andDo(document("user",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())
                        ));


/*        this.mockMvc.perform(get("/user/ALAN/getExternalUserIdFromUserId").accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string(""))
                .andExpect(status().isNotFound());*/

    }

    @Test
    public void getUserId() throws Exception {
        this.mockMvc.perform(get("/user/ERP_ALANY/getUserIdFromExternalUserId").accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string("ALANY"))
                .andExpect(status().isOk());

/*        this.mockMvc.perform(get("/user/ERP_ALAN/getUserIdFromExternalUserId").accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string(""))
                .andExpect(status().isNotFound());*/
    }

}