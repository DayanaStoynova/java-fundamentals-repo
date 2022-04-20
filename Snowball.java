import java.util.Scanner;

public class Snowball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        double SnowballValueMax = Double.MIN_VALUE;
        int SnowballSnowMax = 0;
        int SnowballTimeMax = 0;
        int SnowballQualityMax = 0;
        for (int i = 1; i <=N ; i++) {
            int SnowballSnow = Integer.parseInt(scanner.nextLine());
            int SnowballTime = Integer.parseInt(scanner.nextLine());
            int SnowballQuality = Integer.parseInt(scanner.nextLine());
            int n = SnowballSnow/SnowballTime;
            double SnowballValue = Math.pow(n,SnowballQuality);
            if(SnowballValue>SnowballValueMax){
                SnowballValueMax=SnowballValue;
                SnowballSnowMax = SnowballSnow;
                SnowballTimeMax = SnowballTime;
                SnowballQualityMax = SnowballQuality;

            }
        }
        //"{snowballSnow} : {snowballTime} = {snowballValue} ({snowballQuality})"
        System.out.printf("%d : %d = %.0f (%d)",SnowballSnowMax,SnowballTimeMax,SnowballValueMax,SnowballQualityMax);
    }
}
