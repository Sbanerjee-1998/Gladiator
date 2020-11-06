package com.lti.entity;

import java.time.LocalDate;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
@Entity
@Table(name="applicant_table")
@NamedQuery(name="fetch-all",query="select a from Applicant a")
public class Applicant {
    @Id
    @GeneratedValue
    private int Id;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private String mobile;
    private LocalDate dateOfBirth;
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}