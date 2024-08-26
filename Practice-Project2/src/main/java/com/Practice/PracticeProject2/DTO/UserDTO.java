package com.Practice.PracticeProject2.DTO;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * The class is used by UserServiceImpl class because of the custom user details class
 * this DTO class will encapsulate data transferred between the controller layer and service layer.
 * The DTO and entity model (employee) have the exact same fields and types, so the DTO can be used
 * directly without mapping.
 */
public class UserDTO
{
    private BigInteger employeeid;
    private String role;
    private boolean enabled;
    private String username;
    private String jobtitle;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String password;
    private Timestamp datehired;
    private Timestamp datefired;

    public UserDTO() { }

    public UserDTO(String role, boolean enabled, String username, String jobtitle, String firstname,
                   String lastname, String phone, String email, String password, Timestamp datehired,
                   Timestamp datefired)
    {
        this.role = role;
        this.enabled = enabled;
        this.username = username;
        this.jobtitle = jobtitle;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.datehired = datehired;
        this.datefired = datefired;
    }

    public BigInteger getEmployeeid() {return employeeid;}

    public void setEmployeeid(BigInteger employeeid) {this.employeeid = employeeid;}

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}

    public boolean isEnabled() {return enabled;}

    public void setEnabled(boolean enabled) {this.enabled = enabled;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getJobtitle() {return jobtitle;}

    public void setJobtitle(String jobtitle) {this.jobtitle = jobtitle;}

    public String getFirstname() {return firstname;}

    public void setFirstname(String firstname) {this.firstname = firstname;}

    public String getLastname() {return lastname;}

    public void setLastname(String lastname) {this.lastname = lastname;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public Timestamp getDatehired() {return datehired;}

    public void setDatehired(Timestamp datehired) {this.datehired = datehired;}

    public Timestamp getDatefired() {return datefired;}

    public void setDatefired(Timestamp datefired) {this.datefired = datefired;}
}
