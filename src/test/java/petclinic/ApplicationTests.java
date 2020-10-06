package petclinic;

import java.net.URI;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestClientException;
import petclinic.Model.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("dev")
class ApplicationTests {
	public static final String restLocation ="http://localhost:8080/rest";

	@Autowired
	private TestRestTemplate restTemplate;

	@BeforeEach
	public void setUp(){
		restTemplate = restTemplate.withBasicAuth("user2","password");
	}
	@Test
	public void testGetOwnerById() {
		try{
			ResponseEntity <Owner> response = restTemplate.getForEntity("http://localhost:8080/rest/owner/2",Owner.class);
			MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200)); // success
			System.out.println(response);
		}
		catch(RestClientException ex){ex.printStackTrace();
		}
	}
	@Test
	public void testUpdateOwner() {
		Owner owner = restTemplate.getForObject(restLocation + "/owner/1", Owner.class);
		assert owner != null;
		MatcherAssert.assertThat(owner.getFirstName(), Matchers.equalTo("Ziya"));

		owner.setFirstName("UpdatedUser3");
		owner.setLastName("UpdatedLastName3");
		restTemplate.put(restLocation + "/owner/3", owner);
		
		owner = restTemplate.getForObject(restLocation + "/owner/3",Owner.class);
		assert owner != null;
		MatcherAssert.assertThat(owner.getFirstName(), Matchers.equalTo("UpdatedUser3"));
	}
	@Test
	public void testCreateOwner(){
		Owner owner = new Owner("Hilmi", "Arıkmert", 5L);
		URI location = restTemplate.postForLocation(restLocation + "/owner/", owner);

	assert location != null;
	Owner owner2 = restTemplate.getForObject(location, Owner.class);

	assert owner2 != null;
	MatcherAssert.assertThat(owner2.getFirstName(), Matchers.equalTo(owner.getFirstName()));
	MatcherAssert.assertThat(owner2.getLastName(), Matchers.equalTo(owner.getLastName()));
	}
	@Test
	public void testDeleteOwner() {
		restTemplate.delete(restLocation + "/owner/2", Owner.class);
		try {
			restTemplate.getForEntity(restLocation + "/owner/2", Owner.class);
			System.out.println("should have not returned the message");
		}catch (RestClientException ex){
			ex.printStackTrace();
		}
	}
}
