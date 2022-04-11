import java.util.Scanner;

public class dayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dayOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int day = Integer.parseInt(scanner.nextLine());
        if(day>=1 && day<=7){
            System.out.println(dayOfWeek[day-1]);
        }else{
            System.out.println("Invalid day!");
        }

    }
}
