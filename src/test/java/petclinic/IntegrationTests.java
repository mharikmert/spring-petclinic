package petclinic;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import petclinic.Model.Vet;
import petclinic.Service.PetClinicService;
import petclinic.Model.Owner;

import java.util.List;
@SpringBootTest(properties = {"spring.profiles.active = dev"})
public class IntegrationTests {
    @Autowired
    private PetClinicService petClinicService;

    @Test
    public void findOwners(){
        List<Owner> owners = petClinicService.findOwners();
        MatcherAssert.assertThat(owners.size(), Matchers.equalTo(10));
    }

    @Test
    public void testFindVets(){
        List<Vet> vets = petClinicService.findVets();
        MatcherAssert.assertThat(vets.size(), Matchers.equalTo(3));
    }

}
