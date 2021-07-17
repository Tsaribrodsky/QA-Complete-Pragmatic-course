import java.util.Scanner;

public class Mission5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter A:");
        int A = scanner.nextInt();

        System.out.println("Enter B:");
        int B = scanner.nextInt();

        System.out.println("Enter C:");
        int C = scanner.nextInt();

        if (A > B && B > C) {
            System.out.println(A);
            System.out.println(B);
            System.out.println(C);
        } else if (B > A && A > C) {
            System.out.println(B);
            System.out.println(A);
            System.out.println(C);
        } else if (C > B && B > A) {
            System.out.println(C);
            System.out.println(B);
            System.out.println(A);
        } else if (A > C && C > B) {
            System.out.println(A);
            System.out.println(C);
            System.out.println(B);
        }
    }
}
