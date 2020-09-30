package petclinic.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import petclinic.Properties;

import javax.annotation.PostConstruct;

@Configuration
public class ConfigurationClass {
    @Autowired // defining properties with autowired
    private Properties getProperty;

    @PostConstruct // see the method content while initializing
    public void anyName(){
        System.out.println("is the value of newProperty is still false? : " + getProperty.isNewProperty());
    }
}