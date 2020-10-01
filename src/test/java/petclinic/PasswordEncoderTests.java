package petclinic;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTests {
    @Test
    public void passwordEncryptionTest(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("{bcrypt}" + encoder.encode("password"));
        System.out.println("{bcrypt}" + encoder.encode("password"));
        System.out.println("{bcrypt}" + encoder.encode("password"));
    }
}
