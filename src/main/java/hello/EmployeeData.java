package hello;


public interface EmployeeData {
    Employee getEmployee(String email);

    void addEmployee(Employee e);

    Employee deleteEmployee(String email);

    int size();
}
