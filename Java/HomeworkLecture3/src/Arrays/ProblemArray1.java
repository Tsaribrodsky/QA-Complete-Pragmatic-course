package Arrays;

import java.util.Scanner;

public class ProblemArray1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size");
        int n = scanner.nextInt();

        int[] myFirstArr = new int[n];

        for (int i = 0; i < myFirstArr.length; i++) {
            System.out.println("Enter value");
            myFirstArr[i] = scanner.nextInt();
        }

        for (int i = 0; i < myFirstArr.length; i++) {
            if (myFirstArr[i] % 3 == 0) {
                for (int a = 0; a < myFirstArr.length; a++) {
                    if (myFirstArr[i] > myFirstArr[a] && myFirstArr[a] % 3 == 0) {
                        myFirstArr[i] = myFirstArr[a];
                    }
                }
                System.out.println(myFirstArr[i]);
                break;
            } else {
                System.out.println(" There is no number divisible by 3");
                break;
            }
        }
    }
}
