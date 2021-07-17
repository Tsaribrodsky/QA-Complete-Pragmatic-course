package person;

public class Employee extends Person{

    private double daySalary;

    Employee(String name, int age, boolean isMan, double daySalary){
        super(name, age, isMan);
        this.daySalary = daySalary;
    }

    double calculateOvertime(double hours) {
        double overtime;
        if (getAge() < 18) {
            overtime = 0;
        } else {
            overtime = ((getDaySalary()/8) * 1.5) * hours;
        }
        return overtime;
    }

    public void showEmployeeInfo() {
        super.showPersonInfo();
        System.out.println(getName() + " earn " + getDaySalary() + " a day.");
    }

    public double getDaySalary() {
        return daySalary;
    }
}
