import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class emojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("(?<name>[:]{2}(?<emoji>[A-Z][a-z]{2,})[:]{2}|[*]{2}(?<emoj>[A-Z][a-z]{2,})[*]{2})");
        Pattern numPattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(input);
        Matcher numMatcher = numPattern.matcher(input);
        List<String> coolEmojis = new ArrayList<>();
        int counter = 0;
        long threshold = 1;
        while (numMatcher.find()){
            int num = Integer.parseInt(numMatcher.group());
            threshold*=num;
        }
        while (matcher.find()){
            counter++;
            int coolness = 0;
            String emoji = matcher.group("name");

            for (int i = 2; i < emoji.length()-2; i++) {
                int symbol = emoji.charAt(i);
                coolness+=symbol;
            }
            if(coolness>threshold){
                coolEmojis.add(matcher.group());
            }
        }
        System.out.printf("Cool threshold: %d%n",threshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n",counter);
        for (String emoji:coolEmojis) {
            System.out.println(emoji);
        }
    }
}
