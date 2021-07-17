package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemArray2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number 8");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        if (n % 2 == 0) {
            for (int i = 0; i < arr.length/2; i++) {
                System.out.println("Enter value");
                arr[i] = scanner.nextInt();
//                arr[arr.length / 2 + i] = arr[i];
            }
        } else {
            System.out.println("Entered number is not divisible by 2");
        }

//        int [] half = new int[n];
//        System.arraycopy(half.length/2, 0, (arr.length - 1)/2, arr.length/2, arr.length);
        System.out.println(Arrays.toString(arr));

        if (n % 2 == 0) {
            for (int i = 0; i < arr.length; i++) {
                if (i >= (arr.length/2)) {
                    for (int a = i - (arr.length/2); a < arr.length/2; a++) {
                        arr[i] = arr[a];
                        break;
                    }
                }
            System.out.print(arr[i] + " ");
            }
        }
    }
}
