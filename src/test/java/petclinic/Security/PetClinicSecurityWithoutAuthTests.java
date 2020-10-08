package petclinic.Security;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import petclinic.Service.PetClinicService;

@SpringBootTest(properties = "spring.profiles.active = dev")
public class PetClinicSecurityWithoutAuthTests {
    @Autowired
    private PetClinicService petClinicService;

    @Test
    public void testFindOwners(){
        Assertions.assertThrows(AuthenticationCredentialsNotFoundException.class, () -> {//allow to method throws this exception
            petClinicService.findOwners();
        });
    }
}
