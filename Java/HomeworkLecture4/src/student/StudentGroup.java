package student;

public class StudentGroup {
    String groupSubject;
    Student[] students;
    int freePlaces;

    StudentGroup(){
        students = new Student[5];
        this.freePlaces = 5;
    }

    StudentGroup(String groupSubject) {
        this();
        this.groupSubject = groupSubject;
    }

    void addStudent(Student s) {
        if (freePlaces == 0) {
            System.out.println("No free places");
        } else if (!s.subject.equals(groupSubject)){
            System.out.println(s.name + " must be in " + s.subject + " not in " + groupSubject);
        } else {
            students[students.length - freePlaces] = s;
            freePlaces--;
            System.out.println("Added student " + s.name + " in " + groupSubject + " group");
        }
    }

    void emptyGroup(){
        freePlaces = 5;
        students = new Student[5];
    }

    String theBestStudent() {
        Student bestStudent = students[0];

        for (int i = 1; i < students.length - freePlaces; i++){
            if (students[i].grade > bestStudent.grade) {
                bestStudent = students[i];
            }
        }
        return bestStudent.name;
    }

    void printStudentsInGroup() {
        for (int i = 0; i < students.length - freePlaces; i++) {
            System.out.println("Name: " + students[i].name + ", Subject: " + students[i].subject + ", Grade: " +
            students[i].grade + ", Year in college: " + students[i].yearInCollege + ", Age: " + students[i].age +
            ", Is degree: " + students[i].isDegree + ", Money: " + students[i].money);
        }
    }
}
