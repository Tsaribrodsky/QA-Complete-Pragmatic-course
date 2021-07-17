package student;

public class College {
    public static void main(String[] args) {
        Student dani = new Student();
        dani.name = "dani";
        dani.age = 37;
        dani.subject = "Java";
        dani.grade = 5;

        Student messi = new Student("messi", "Java", 29);
        Student ani = new Student("ani", "Java", 33);
        Student niki = new Student("niki", "Java", 38);
        Student denis = new Student("denis", "Java", 25);
        Student petya = new Student("petya", "Java", 27);
        Student grandfather = new Student("ivan", "SQL", 78);
        Student pamela = new Student("pamela", "Linux", 50);
        Student selena = new Student("selena gomez", "Linux", 25);

        ani.receiveScholarship(3, 50);
        denis.receiveScholarship(3, 50);
        petya.receiveScholarship(3, 50);
        messi.receiveScholarship(3, 50);

        dani.upYear();
        denis.upYear();
        messi.upYear();

        System.out.println("dani is " + dani.yearInCollege + " years in college");

        StudentGroup java = new StudentGroup("Java");
        StudentGroup sql = new StudentGroup("SQL");
        StudentGroup linux = new StudentGroup("Linux");

        java.addStudent(dani);
        java.addStudent(messi);
        java.addStudent(ani);
        java.addStudent(niki);
        java.addStudent(denis);
        java.addStudent(petya);

        sql.addStudent(grandfather);
        sql.addStudent(messi);

        linux.addStudent(dani);
        linux.addStudent(pamela);
        linux.addStudent(selena);

        System.out.println(java.freePlaces + " free places in Java Group");
        System.out.println(sql.freePlaces + " free places in SQL Group");
        System.out.println(linux.freePlaces + " free places in Linux Group");

        java.theBestStudent();
        System.out.println(java.theBestStudent() + " is the best student");

        java.printStudentsInGroup();
        sql.printStudentsInGroup();
        linux.printStudentsInGroup();

        java.emptyGroup();
        System.out.println(java.freePlaces + " free places in Java Group");
    }
}
