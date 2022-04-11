import java.util.Arrays;
import java.util.Scanner;

public class equalArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] first = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] second = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        boolean areEqual = true;
        if (first.length == second.length) {
            for (int i = 0; i <= first.length - 1; i++) {
                sum += first[i];
                if (first[i] != second[i]) {
                    areEqual = false;
                    System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                    break;
                }
            }
            if (areEqual) {
                System.out.printf("Arrays are identical. Sum: %d", sum);
            }

        } else {
            int longerArr = Integer.max(first.length, second.length);
            int diff = Math.abs(first.length - second.length);
            int index = longerArr - diff;
            System.out.printf("Arrays are not identical. Found difference at %d index.", index);
        }

    }
}
