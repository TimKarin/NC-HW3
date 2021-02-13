package ru.karin.nc.hw3.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

    @Pattern(regexp = "([а-яА-Яa-zA-z]{3,20})")
    private String firstName;

    @Pattern(regexp = "([а-яА-Яa-zA-z]{3,20})")
    private String lastName;

    @Pattern(regexp = "(19\\d\\d|20[01]\\d)-((0[1-9]|1[012])-(0[1-9]|[12]\\d)|(0[13-9]|1[012])-30|(0[13578]|1[02])-31)")
    private String birthday;

    @Min(1)
    private int salary;

    @Pattern(regexp = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$")
    private String email;

    @Size(min=2, max=40)
    private String companyName;

    public User() {
        firstName = null;
        lastName = null;
        birthday = null;
        salary = 0;
        email = null;
        companyName = null;
    }
    public User(String[] userStr) {
        this.firstName = userStr[0];
        this.lastName = userStr[1];
        this.birthday = userStr[2];
        this.salary = Integer.parseInt(userStr[3]);
        this.email = userStr[4];
        this.companyName = userStr[5];
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return firstName + "#" + lastName + "#" + birthday + "#" + salary + "#" + email + "#" + companyName;
    }
}
