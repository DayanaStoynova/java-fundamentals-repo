import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        int Y = Integer.parseInt(scanner.nextLine());
        double halfN = 0.5*N;
        int targets = 0;
        while (N>=M){
            if(N==halfN && Y!=0){
                N/=Y;
                continue;
            }
            N = N-M;
            targets++;
        }
        System.out.println(N);
        System.out.println(targets);
    }
}
