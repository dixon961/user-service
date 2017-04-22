package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ServiceController {

    private EmployeeData employeeData = new MongoData();

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
            return new Message("Wrong input");
        }
        employeeData.addEmployee(e);
        return new Message("Employee added");

    }

    @RequestMapping("/employee/get")
    public Employee getEmployee(
            @RequestParam(value="email", required=true) String email
    ) {
        if (employeeData.getEmployee(email) != null)
            return employeeData.getEmployee(email);
        else
            return new Employee("empty", "empty", "empty", "empty", "empty");
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