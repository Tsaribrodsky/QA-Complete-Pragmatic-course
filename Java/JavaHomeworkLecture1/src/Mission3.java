import java.util.Scanner;

public class Mission3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter A:");
        int A = scanner.nextInt();

        System.out.println("Enter B:");
        int B = scanner.nextInt();

        A = A + B;
        B = A - B;
        A = A - B;

        System.out.println("A = " + A);
        System.out.println("B = " + B);
    }
}
