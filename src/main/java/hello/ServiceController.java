package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    private  EmployeeSet eSet = new EmployeeSet();

    @RequestMapping("/employee/add")
    public Message addEmployee(
            @RequestParam(value="name", required=true) String name,
            @RequestParam(value="lastName", required=true) String lastName,
            @RequestParam(value="email", required=true) String email,
            @RequestParam(value="password", required=true) String password,
            @RequestParam(value="date", required=true) String date
            ) {
        eSet.addEmployee(new Employee(name, lastName, email, password, date));
        return new Message("Employee added");
    }

    @RequestMapping("/employee/get")
    public Employee getEmployee(
            @RequestParam(value="email", required=true) String email
    ) {
        if (eSet.getEmployee(email) != null)
            return eSet.getEmployee(email);
        else
            return new Employee("empty", "empty", "empty", "empty", "empty");
    }

    @RequestMapping("/employee/delete")
    public Message deleteEmployee(
            @RequestParam(value="email", required=true) String email
    ) {
        eSet.deleteEmployee(email);
        return new Message("Employee deleted");
    }
}