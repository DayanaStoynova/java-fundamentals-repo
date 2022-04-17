import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int p = Integer.parseInt(scanner.nextLine());
        int courses = n/p;
        if(n%p!= 0){
            courses+=1;
        }
        System.out.println(courses);
    }
}
