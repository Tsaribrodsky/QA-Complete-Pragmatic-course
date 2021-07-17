package person;

public class LiveDemo {
    public static void main(String[] args) {

        Person niki = new Person("Niki", 23, true);
        Person ani  = new Person("Ani", 16, false);
        Student dani = new Student("Dani", 27, true, 6);
        Student max = new Student("Max", 43, true, 7);
        Employee monica = new Employee("Monica", 33, false, 80);
        Employee donica = new Employee("Donica", 17, false, 8);

        Person[] various = new Person[10];
        various[0] = niki;
        various[1] = ani;
        various[2] = dani;
        various[3] = max;
        various[4] = monica;
        various[5] = donica;

        for (int i = 0; i < various.length; i++) {
            if (various[i] != null) {
                System.out.println("");
                if (various[i] instanceof Student) {
                    ((Student)various[i]).showStudentInfo();
                    continue;
                }
                if (various[i] instanceof Employee) {
                    ((Employee)various[i]).showEmployeeInfo();
                    continue;
                }
                if (various[i] instanceof Person) {
                    various[i].showPersonInfo();
                }
            }
        }

        for (int i = 0; i < various.length; i++) {
            if (various[i] != null) {
                System.out.println("");
                if (various[i] instanceof Employee) {
                    System.out.println(various[i].getName() + " earn overtime " + ((Employee)various[i]).calculateOvertime(2));
                }
            }
        }
    }
}
