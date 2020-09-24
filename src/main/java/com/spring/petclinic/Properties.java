package com.spring.petclinic;
import org.springframework.boot.context.properties.ConfigurationProperties;
import javax.annotation.PostConstruct;

@ConfigurationProperties(prefix = "myprefix")
class Properties {
    private boolean newProperty = false;
    @PostConstruct
    public void print(){
        System.out.println("will it be written to the console this too-> " + this.newProperty);
    }
    public boolean isNewProperty(){
        return this.newProperty;
    }
    public void setNewProperty(boolean newProperty){
        this.newProperty = newProperty;
    }
}
