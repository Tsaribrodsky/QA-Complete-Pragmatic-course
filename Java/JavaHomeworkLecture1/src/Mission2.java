import java.util.Scanner;

public class Mission2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter A:");
        double A = scanner.nextDouble();

        System.out.println("Enter B:");
        double B = scanner.nextDouble();

        double sum = A + B;
        double subtraction = A - B;
        double multiplication = A * B;
        double division = A / B;
        double remainder = A % B;

        System.out.println("A + B = " + sum);
        System.out.println("A - B = " + subtraction);
        System.out.println("A * B = " + multiplication);
        System.out.println("A / B = " + division);
        System.out.println("A % B = " + remainder);
    }
}
