package hello;


public interface EmployeeData {
    Employee getEmployee(String email);

    void addEmployee(Employee e);

    void deleteEmployee(String email);

    int size();
}
