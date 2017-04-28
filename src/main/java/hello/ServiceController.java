package hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@ConfigurationProperties
@RestController
public class ServiceController {

    private EmployeeData employeeData = new MongoData();
    @Value("${error_msg}")
    private String errorMessage;

    @RequestMapping("/employee/add")
    public Message addEmployee(
            @RequestParam(value="name", required=true) String name,
            @RequestParam(value="lastName", required=true) String lastName,
            @RequestParam(value="email", required=true) String email,
            @RequestParam(value="password", required=true) String password,
            @RequestParam(value="date", required=true) String date
            ) {
        Employee e;
        try{
            e = new Employee(name, lastName, email, password, date);
        }
        catch (IllegalArgumentException ex){
            return new Message(errorMessage + ": " +  ex.getMessage());
        }
        employeeData.addEmployee(e);
        return new Message("Employee added");

    }

    @RequestMapping("/employee/get")
    public Employee getEmployee(
            @RequestParam(value="email", required=true) String email
    ) {
        Employee e;
        try {
            e = employeeData.getEmployee(email);
        }
        catch (Exception ex){
            e = new Employee("empty", "empty", "empty@empty.com", "empty", "01-01-1900");
        }
        return e;
    }

    @RequestMapping("/employee/delete")
    public Message deleteEmployee(
            @RequestParam(value="email", required=true) String email
    ) {
        if (employeeData.deleteEmployee(email) != null)
            return new Message("Employee deleted");
        else
            return new Message("No such employee");
    }
}