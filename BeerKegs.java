import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double maxKeg = Double.MIN_VALUE;
        String modelMax = "";
        for (int i = 1; i <=n ; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());
            double volume = Math.PI*Math.pow(radius,2)*height;
            if(volume>maxKeg){
                maxKeg = volume;
                modelMax = model;
            }
        }
        System.out.println(modelMax);
    }
}
