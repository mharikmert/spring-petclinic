package petclinic.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import petclinic.Properties;

import javax.annotation.PostConstruct;

@Configuration
public class ConfigurationClass {

    private Properties getProperty;
    @Autowired
    public void setGetProperty(Properties getProperty){this.getProperty = getProperty;};

    @PostConstruct // see the method content while initializing
    public void anyName(){
        System.out.println("is the value of newProperty is still false? : " + getProperty.isNewProperty());
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}