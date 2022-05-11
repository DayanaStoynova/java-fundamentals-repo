import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class destinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("(?<first>[=/])(?<destination>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(input);
        List<String> destinations = new ArrayList<>();
        int totalPoints = 0;
        while(matcher.find()){
            String destination = matcher.group("destination");
            destinations.add(destination);
            int points = matcher.group("destination").length();
            totalPoints+=points;
        }
        System.out.print("Destinations: ");
        for (int i = 0; i < destinations.size(); i++) {
            String destination = destinations.get(i);
            System.out.print(destination);
            if(i<destinations.size()-1){
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.printf("Travel Points: %d",totalPoints);
    }
}
