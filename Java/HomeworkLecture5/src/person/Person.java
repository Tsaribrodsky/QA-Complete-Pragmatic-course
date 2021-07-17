package person;

public class Person {
    private String name;
    private int age;
    private boolean isMan;

    Person(String name, int age, boolean isMan) {
        this.name = name;
        this.age = age;
        this.isMan = isMan;
    }

     public void showPersonInfo() {
         System.out.println(getName() + " is " + getAge() + " years old. He is a man: " + isMan());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMan() {
        return isMan;
    }
}
