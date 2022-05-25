import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> mirrorWords = new LinkedHashMap<>();
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("([@#])(?<word1>[A-za-z]{3,})\\1{2}(?<word2>[A-za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            String firstWord = matcher.group("word1");
            StringBuilder secondWord = new StringBuilder(matcher.group("word2"));
            String secondWordS = secondWord.toString();
            StringBuilder secondReversed = secondWord.reverse();
            count++;
            if (firstWord.equals(secondReversed.toString()) && firstWord.length() == secondWord.length()) {
                mirrorWords.put(firstWord, secondWordS);
            }
        }
        if (count == 0) {
            System.out.println("No word pairs found!");
        }
        if (mirrorWords.isEmpty()) {
            if(count>0) {
                System.out.printf("%d word pairs found!%n", count);
            }
            System.out.println("No mirror words!");
        } else {
            System.out.printf("%d word pairs found!%n", count);
            System.out.println("The mirror words are:");
            int countSet = 0;
            for (Map.Entry<String, String> entry : mirrorWords.entrySet()) {
                System.out.printf("%s <=> %s", entry.getKey(), entry.getValue());
                if (countSet < mirrorWords.size() - 1) {
                    System.out.print(", ");
                }
                countSet++;
            }
        }
    }
}
