package study.hello;

import org.springframework.context.annotation.Profile;

import java.util.HashMap;

@Profile("default")
public class EmployeeSet implements EmployeeData{
    private HashMap<String, Employee> employees;

    public EmployeeSet(){
        this.employees = new HashMap<>();
    }

    public Employee getEmployee(String email){
        return this.employees.get(email);
    }

    public void addEmployee(Employee e){
        this.employees.put(e.getEmail(), e);
    }

    public Employee deleteEmployee(String email){
        return this.employees.remove(email);
    }

    public int size(){
        return this.employees.size();
    }
}
