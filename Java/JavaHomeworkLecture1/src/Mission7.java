import java.util.Scanner;

public class Mission7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter time in hours:");
        int hour = scanner.nextInt();

        System.out.println("Enter sum of money:");
        double money = scanner.nextDouble();

        System.out.println("Whether I'm healthy?");
        boolean healthy = scanner.nextBoolean();

        if (healthy) {
            System.out.println("I'm healthy!");
        } else {

            if (money > 0) {
                System.out.println("I will buy medicaments and stay at home.");
            } else {
                System.out.println("I will stay at home and drink tea.");
            }
        }

        if (healthy && money < 10) {
            System.out.println("Coffee time!");
        } else {
            System.out.println("I'm rich! :)");

            if (hour > 20) {
                System.out.println("Party time!");
            }
        }
    }
}
