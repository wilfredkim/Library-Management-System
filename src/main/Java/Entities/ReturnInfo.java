package Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name = "viewreturnInfobyId", query = "select  r from ReturnInfo  r where r.issuedBook=:issueBook")
public class ReturnInfo {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
     @ManyToOne
     IssuedBook issuedBook;
     int late_days;
     float penalty;
     Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public IssuedBook getIssuedBook() {
        return issuedBook;
    }

    public void setIssuedBook(IssuedBook issuedBook) {
        this.issuedBook = issuedBook;
    }

    public int getLate_days() {
        return late_days;
    }

    public void setLate_days(int late_days) {
        this.late_days = late_days;
    }

    public float getPenalty() {
        return penalty;
    }

    public void setPenalty(float penalty) {
        this.penalty = penalty;
    }
}