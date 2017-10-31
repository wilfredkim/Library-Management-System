package Entities;

import Enums.Year;

import javax.persistence.*;

@Entity
@NamedQueries({@NamedQuery(name = "authenticate",query = "select  s from Student s where s.email=:mail and s.password=:pass"),
        @NamedQuery(name = "searchStudent", query = "select  s from  Student  s where  s.regNo=:regNo")})

public class Student extends Person {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private  long id;
    @Column(unique = true)
    private  String regNo;
    private String year;

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getYear() {
        return year;
    }



    public void setYear(String year) {
        this.year = year;
    }
}
