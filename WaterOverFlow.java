import java.util.Scanner;

public class WaterOverFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tankCapacity = 255;
        int n = Integer.parseInt(scanner.nextLine());
        int litresSum = 0;
        for (int i = 1; i <=n ; i++) {
            int litresOfWater = Integer.parseInt(scanner.nextLine());
            if(tankCapacity-litresSum<litresOfWater){
                System.out.println("Insufficient capacity!");
                continue;
            }
            litresSum+=litresOfWater;
        }
        System.out.println(litresSum);


    }
}
