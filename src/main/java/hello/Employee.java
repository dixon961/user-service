package hello;

import java.security.MessageDigest;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Employee implements Comparable<Employee>{
    private String name;
    private String lastName;
    private String email;
    private byte[] password;
    private LocalDate birthDate;



    public Employee(String name, String lastName, String email, String password, String birthDate) throws IllegalArgumentException, DateTimeParseException{
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        if (!birthDate.matches("\\d\\d-\\d\\d-\\d\\d\\d\\d") ||
                !name.matches("[a-zA-Z]+") ||
                !lastName.matches("[a-zA-Z]+") ||
                !email.matches(".+@.+"))
            throw new IllegalArgumentException("Wrong date");
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        try {
            this.password = MessageDigest.getInstance("MD5").digest(password.getBytes("UTF-8"));
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

    public byte[] getPassword() {
        return password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
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
