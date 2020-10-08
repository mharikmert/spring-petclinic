package petclinic.Security;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import petclinic.Service.PetClinicService;

@SpringBootTest(properties = "spring.profiles.active = dev")
public class ValidTokenTests {
    @Autowired
    private PetClinicService petClinicService;

    @BeforeEach
    public void setUp(){
        TestingAuthenticationToken auth = new
                //just authority enough to be reach the method
                TestingAuthenticationToken("invalidUser", "invalidPassword", "ROLE_USER");
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
    @AfterEach
    public void tearDown(){
        SecurityContextHolder.clearContext();
    }
    @Test
    public void testFindOwners(){
        petClinicService.findOwners();
        MatcherAssert.assertThat(petClinicService.findOwners().size(), Matchers.equalTo(10));
    }

}
