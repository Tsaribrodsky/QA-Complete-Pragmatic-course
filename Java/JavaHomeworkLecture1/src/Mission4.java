import java.util.Scanner;

public class Mission4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number A:");
        int A = scanner.nextInt();

        System.out.println("Enter number B:");
        int B = scanner.nextInt();

        if (A < B) {
            System.out.println(A);
            System.out.println(B);
        } else {
            System.out.println(B);
            System.out.println(A);
        }
    }
}
