package study.hello;

import org.springframework.data.annotation.Id;
import java.security.MessageDigest;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Employee implements Comparable<Employee>{

    @Id
    private String id;

    private String name;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthDate;

    public Employee(){

    }

    public Employee(String name, String lastName, String email, String password, String birthDate)
            throws IllegalArgumentException, DateTimeParseException{

        if (!birthDate.matches("\\d\\d-\\d\\d-\\d\\d\\d\\d"))
            throw new IllegalArgumentException("Wrong date! " + birthDate);
        if (!name.matches("[a-zA-Z]+"))
            throw new IllegalArgumentException("Wrong first name! " + name);
        if (!lastName.matches("[a-zA-Z]+"))
            throw new IllegalArgumentException("Wrong lastname! " + lastName);
        if (!email.matches(".+@.+"))
            throw new IllegalArgumentException("Wrong e-mail! " + email);

        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        try {
            this.password = new String(MessageDigest.getInstance("MD5").digest(password.getBytes("UTF-8")));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setName(String name){ this.name = name; }

    public void setLastName(String name) {this.name = name; }

    public void setEmail(String email){ this.email = email; }

    public void setPassword(String pswrd) {this.password = pswrd; }

    public void setBirthDate(LocalDate date) { this.birthDate = date; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int compareTo(Employee e) {
        if (this.email.compareTo(e.email) < 0)
            return -1;
        else if (this.email.compareTo(e.email) > 0)
            return 1;
        return 0;
    }

}
