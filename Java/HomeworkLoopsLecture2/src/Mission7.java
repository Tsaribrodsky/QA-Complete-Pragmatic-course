import java.util.Scanner;

public class Mission7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number");
        int n = scanner.nextInt();

        int fac = 3;

        for (int i = 1; i <= n; i++) {

            if (fac % 3 == 0) {
                System.out.print(fac + ",");
                fac = fac + 3;
            }
        }
        System.out.println("\b");
    }
}
