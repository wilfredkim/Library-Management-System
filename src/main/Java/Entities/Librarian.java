package Entities;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "authenticateLibrarian",query = "select l from  Librarian l where l.email=:mail and l.password=:pass"),
        @NamedQuery(name = "viewAll", query = "select  l from Librarian  l"),
        @NamedQuery(name = "deleteLibrarian", query = "delete  from  Librarian  l where l.workNumber=:num")
})


public class Librarian extends Person {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private  long id;
    @Column(unique = true)
    private  String workNumber;

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }
}
