package petclinic.Security;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import petclinic.Service.PetClinicService;

import java.nio.file.AccessDeniedException;

@SpringBootTest(properties = "spring.active.profiles = dev")
public class InvalidTokenTests {
    @Autowired
    private PetClinicService petClinicService;

    @BeforeEach
    public void setUp(){
        //Expected access denied exception with invalid token
        TestingAuthenticationToken auth = new
                TestingAuthenticationToken("invalidUserName", "invalidPassword","InvalidRole");
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
    @AfterEach
    public void tearDown(){
        //clear the authority in contextHolder for security
        SecurityContextHolder.clearContext();
    }

    @Test
    public void testFindOwners(){
        Assertions.assertThrows(AccessDeniedException.class, () -> {
            petClinicService.findOwners();
        });
    }
}
