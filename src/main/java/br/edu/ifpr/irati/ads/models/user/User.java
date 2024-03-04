package br.edu.ifpr.irati.ads.models.user;


import br.edu.ifpr.irati.ads.models.enums.TypeUserEnum;
import jakarta.persistence.*;

@Entity(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_user", discriminatorType = DiscriminatorType.STRING)
public class User {

    public User() {
        name = "";
        email = "";
    }

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq-user")
    @SequenceGenerator(name = "seq-user", sequenceName = "USER_SEQ", allocationSize = 1, initialValue = 1)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
