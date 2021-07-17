import java.util.Scanner;

public class Mission10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number");
        int n = scanner.nextInt();

        if (n < 2) {
            System.out.println(n + " is not a prime number");
        }

        for (int i=2; i <= n/2; i++) {
            if (n % i == 0) {
                System.out.println(n + " is not a prime number");
                break;
            }
            System.out.println(n + " is a prime number");
        }
    }
}
