package hello;

import java.util.Date;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class Employee implements Comparable<Employee>{
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String birthDate;
    //private static final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();;

    public Employee(String name, String lastName, String email, String password, String birthDate){
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        //this.password = bcrypt.encode(password);
        this.password = password;
        this.birthDate = birthDate;
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

    public String getBirthDate() {
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
