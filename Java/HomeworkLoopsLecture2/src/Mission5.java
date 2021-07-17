import java.util.Scanner;

public class Mission5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter namber a:");
        int a = scanner.nextInt();

        System.out.println("Enter number b:");
        int b = scanner.nextInt();

        if (a < b) {
            for (int i = a; i <= b; i++) {
                System.out.print(i + " ");
            }
        }

        if (a > b) {
            for (int i = b; i <= a; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
