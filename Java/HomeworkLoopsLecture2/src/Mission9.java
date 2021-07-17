import java.util.Scanner;

public class Mission9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number A:");
        int a = scanner.nextInt();

        System.out.println("Enter number B:");
        int b = scanner.nextInt();

        int sum = 0;

        if (a < b) {
            for (int i = a; i <= b; i++) {
                int gradation = i * i;
                if (gradation % 3 == 0) {
                    System.out.print(" skip " + gradation/i + ",");
                } else if (gradation % 3 != 0) {
                    System.out.print(" " + gradation + ",");
                }
                sum += gradation;
                if (sum >= 200) {
                    break;
                }
            }
        }

        if (a > b) {
            for (int i = b; i <= a; i++) {
                int gradation = i * i;
                if (gradation % 3 == 0) {
                    System.out.print(" skip " + gradation/i + ",");
                } else if (gradation % 3 != 0) {
                    System.out.print(" " + gradation + ",");
                }
                sum += gradation;
                if (sum >= 200) {
                    break;
                }
            }
        }
        System.out.print("\b");
    }
}
