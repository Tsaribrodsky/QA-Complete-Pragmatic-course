package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemArray3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number 10");
        int n = scanner.nextInt();

        int[] ar = new int[n];

        System.out.println("Enter value");
        int v = scanner.nextInt();
        ar[0] = v;
        ar[1] = v;

        System.out.println(Arrays.toString(ar));

        for (int i = 2; i < ar.length; i++) {
            ar[i] = ar[i-1] + ar[i-2];
        }

        System.out.println(Arrays.toString(ar));
    }
}
