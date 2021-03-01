package conteudo;

public class Employee implements Comparable<Employee> {
    private String firstName;
    private String secondName;
    private double salary;
    private String department;

    public Employee(String firstName, String secondName, double salary, String department) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return String.format("%s %s", getFirstName(), getSecondName());
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s", getName(), getSalary(), getDepartment());
    }

    @Override
    public int compareTo(Employee o) {
        if(this.salary < o.getSalary())
            return -1;

        if(this.salary > o.getSalary())
            return 1;

        return 0;

    }
}
