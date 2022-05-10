import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class adAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<String> food = new ArrayList<>();
        int totalCalories = 0;
        Pattern pattern = Pattern.compile("(?<symbols>[#\\|])(?<itemName>\\w+\\s?\\w+)(\\1)(?<expirationDate>[0-9]{2}[\\/][\\d]{2}[\\/][\\d]{2})(\\1)(?<calories>[0-9]+)(\\1)");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String item = matcher.group("itemName");
            String expDate = matcher.group("expirationDate");
            int calories = Integer.parseInt(matcher.group("calories"));
            food.add(String.format("Item: %s, Best before: %s, Nutrition: %d", item, expDate, calories));
            totalCalories += calories;
        }
        int days = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", days);
        for (String item: food) {
            System.out.println(item);
        }

    }

}
