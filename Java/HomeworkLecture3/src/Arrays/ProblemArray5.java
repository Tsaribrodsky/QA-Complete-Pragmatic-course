package Arrays;

import java.util.Arrays;

public class ProblemArray5 {
    public static void main(String[] args) {
        double[] arr = new double[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }

        System.out.println(Arrays.toString(arr));
    }
}
