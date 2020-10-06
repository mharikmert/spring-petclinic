package petclinic;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import petclinic.Service.PetClinicService;
import petclinic.Model.Owner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"spring.profiles.active = dev"})
public class IntegrationTests {
    @Autowired
    private PetClinicService petClinicService;

    @Test
    public void findOwners(){
        List<Owner> owners = petClinicService.findOwners();
        MatcherAssert.assertThat(owners.size(), Matchers.equalTo(10));
    }

}
