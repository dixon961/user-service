package hello;

import java.util.HashMap;

public class EmployeeSet {
    private HashMap<String, Employee> employees;

    public EmployeeSet(){
        employees = new HashMap<>();
    }

    public Employee getEmployee(String email){
        return employees.get(email);
    }

    public void addEmployee(Employee e){
        employees.put(e.getEmail(), e);
    }

    public void deleteEmployee(String email){
        employees.remove(email);
    }
}
