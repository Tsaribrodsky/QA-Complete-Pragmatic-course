import java.util.Scanner;

public class Mission1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter A:");
        double A = scanner.nextDouble();

        System.out.println("Enter B:");
        double B = scanner.nextDouble();

        System.out.println("Enter C:");
        double C = scanner.nextDouble();

        if ((A < C && C < B) || (B < C && C < A)) {
            System.out.println("The number " + C + " is between " + A + " and " + B);
        }

        else  {
            System.out.println("The number " + C + " is not between " + A + " and " + B);
        }
    }
}
