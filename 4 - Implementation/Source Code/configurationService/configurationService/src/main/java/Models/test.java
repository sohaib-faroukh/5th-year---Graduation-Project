package Models;

import javax.persistence.*;

@Entity
@Table(name = "TEST")
public class test {


    // "customer_seq" is Oracle sequence name.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;





    // Constructor
    public test() { }

    public test(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    // Setter & Getter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }






}
