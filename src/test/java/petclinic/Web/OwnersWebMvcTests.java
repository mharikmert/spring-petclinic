package petclinic.Web;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;

//@RunWith(SpringRunner.class) //no longer required in Junit5
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ActiveProfiles("dev")
@AutoConfigureMockMvc
@WithMockUser(username = "user", password = "not important", authorities = "USER")
public class OwnersWebMvcTests {
   @Autowired
   public MockMvc mockMvc;

   @Test
    public void testOwners() throws Exception{
       MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/owners");

       ResultActions resultActions = mockMvc.perform(requestBuilder);

       MvcResult mvcResult = resultActions.andReturn();

       ModelAndView mav = mvcResult.getModelAndView();

       assert mav != null;
       MatcherAssert.assertThat(mav.getViewName(), Matchers.equalTo("owners"));
       MatcherAssert.assertThat(mav.getModel().containsKey("owners"), Matchers.is(true));
   }
}
