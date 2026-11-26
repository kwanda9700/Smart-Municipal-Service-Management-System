package za.co.municipality.smartservice.model;

public class Employee extends Person {
    private String employeeNumber;
    private String department;

    public Employee() { }
    public Employee(String fullName, String email, String employeeNumber, String department) {
        super(fullName, email);
        this.employeeNumber = employeeNumber;
        this.department = department;
    }
    public String getEmployeeNumber() { return employeeNumber; }
    public void setEmployeeNumber(String employeeNumber) { this.employeeNumber = employeeNumber; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}
