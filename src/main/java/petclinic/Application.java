package petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
@EnableConfigurationProperties(Properties.class)
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
        System.out.println("Spring boot application works..");
    }
}
