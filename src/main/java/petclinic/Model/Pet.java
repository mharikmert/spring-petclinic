package petclinic.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_PET")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "petClinicSeqGen")
    @SequenceGenerator(name = "petClinicSeqGen", sequenceName = "petclinic_sequence")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Pet(){}
    public Pet(Long id, String name, Date birthDate){
        this.id  = id;
        this.name =name;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}
