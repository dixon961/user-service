package hello;

import java.util.HashMap;

public class EmployeeSet implements EmployeeData{
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

    public Employee deleteEmployee(String email){
        return employees.remove(email);
    }

    public int size(){
        return employees.size();
    }
}
