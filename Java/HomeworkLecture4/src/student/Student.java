package student;

public class Student {
    String name;
    String subject;
    double grade;
    int yearInCollege;
    int age;
    boolean isDegree;
    double money;

    Student() {
        this.grade = 4.0;
        this.yearInCollege = 1;
        this.isDegree = false;
        this.money = 0;
    }

    Student(String name, String subject, int age) {
        this();
        this.name = name;
        this.subject = subject;
        this.age = age;
    }

    void upYear() {
        if (!isDegree && yearInCollege < 4) {
            yearInCollege++;
        } else if (yearInCollege == 4){
            isDegree = true;
            System.out.println("The student has graduated");
        } else if (isDegree) {
            yearInCollege = 4;
            System.out.println("The student has graduated");
        }
    }

    double receiveScholarship(double min, double amount) {
        if (grade >= min && age < 30) {
            money = money + amount;
        }
        return money;
    }
}
