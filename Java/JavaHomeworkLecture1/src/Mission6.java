import java.util.Scanner;

public class Mission6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number a1:");
        int a1 = scanner.nextInt();

        System.out.println("Enter number a2:");
        int a2 = scanner.nextInt();

        System.out.println("Enter number a3:");
        int a3 = scanner.nextInt();

        int b = a1;

        a1 = a2;
        a2 = a3;
        a3 = b;

        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);
        System.out.println("a3 = " + a3);
    }
}
