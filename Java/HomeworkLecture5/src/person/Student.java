package person;

public class Student extends Person{
    private double score;

    Student(String name, int age, boolean isMan, double score) {
        super(name, age, isMan);
        this.score = score;
    }

    public void showStudentInfo() {
        super.showPersonInfo();
        if (score < 2 || score > 6) {
            System.out.println("Entered score should be between 2 and 6.");
        } else {
            System.out.println(getName() + " have evaluation " + getScore());
        }
    }

    public double getScore () {
        return score;
    }
}
