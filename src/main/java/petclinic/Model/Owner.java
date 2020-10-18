package petclinic.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_owner")
public class Owner extends BaseEntity{

    @Column(name = "first_name")
    @NotEmpty(message = "first name can't be empty")
    private String firstName;

    @NotEmpty(message = "last name can't be empty")
    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    public Owner(){
    }
    public Owner(String firstName, String lastName, Long id){
        id = super.getId();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
    @Override
    public String toString() {
        return "Owner{" +
                "id=" + getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
