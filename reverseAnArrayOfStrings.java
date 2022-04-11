import java.util.Arrays;
import java.util.Scanner;
import java.lang.reflect.Array;

public class reverseAnArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        for (int i = 0; i <=(input.length-1)/2 ; i++) {
            String temp = input[i];
            input[i] = input[input.length-1-i];
            input[input.length-1-i]= temp;
        }
        for (int i = 0; i <= input.length-1; i++) {
            System.out.print(input[i] + " ");
        }



    }
}
