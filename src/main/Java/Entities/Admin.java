package Entities;

import javax.persistence.*;

@Entity
@NamedQuery(name = "authenticateAdmin" , query = "select a from Admin  a where  a.email=:mail and a.password=:pass")
public class Admin extends  Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
}
