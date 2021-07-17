import java.util.Scanner;

public class Mission8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number");
        int n = scanner.nextInt();

        int number = n - 1;

        for (int row = 1; row <= n; row++) {


            for (int col = 1; col <= n; col++) {
                System.out.print(number + " ");
            }
            System.out.println();
            number = number +2;
        }
    }
}
//Golemi razsajdenia biaha tuk, no mislia, che osaznah cikala :)