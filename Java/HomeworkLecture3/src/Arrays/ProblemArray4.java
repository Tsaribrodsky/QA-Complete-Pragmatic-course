package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemArray4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number 5");
        int n = scanner.nextInt();

        int[] mirror = new int[n];

        for (int i = 0; i < mirror.length; i++) {
            System.out.println("Enter value");
            mirror[i] = scanner.nextInt();
        }

        int[] firstHalf;
        int[] secondHalf;

        if (n % 2 != 0) {
            firstHalf = Arrays.copyOfRange(mirror, 0, mirror.length/2+1);
            secondHalf = Arrays.copyOfRange(mirror, mirror.length/2, mirror.length);
            System.out.println(Arrays.toString(firstHalf));
            System.out.println(Arrays.toString(secondHalf));
        } else {
            firstHalf = Arrays.copyOfRange(mirror, 0, mirror.length/2);
            secondHalf = Arrays.copyOfRange(mirror, mirror.length/2, mirror.length);
            System.out.println(Arrays.toString(firstHalf));
            System.out.println(Arrays.toString(secondHalf));
        }

        System.out.println(Arrays.toString(mirror));

        for (int i = 0; i < secondHalf.length/2; i++) {
            int a = secondHalf[i];
            secondHalf[i] = secondHalf[secondHalf.length - i - 1];
            secondHalf[secondHalf.length - i - 1] = a;
        }

        System.out.println(Arrays.toString(secondHalf));


        if (Arrays.equals(firstHalf, secondHalf)) {
            System.out.println(Arrays.toString(mirror) + " is mirror");

        }
    }
}
