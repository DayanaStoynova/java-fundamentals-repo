import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingYield = Integer.parseInt(scanner.nextLine());
        int days = 0;
        int yieldSum = 0;
        while (startingYield >= 100) {
            days++;
            int yield = startingYield - 26;
            yieldSum+=yield;
            startingYield-=10;
        }
        if(yieldSum>=26){
            yieldSum-=26;
        }
        System.out.println(days);
        System.out.println(yieldSum);

    }
}
