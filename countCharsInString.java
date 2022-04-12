import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class countCharsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("\\s+");
        Map<Character, Integer> characterCount = new LinkedHashMap<>();
        for (String text : line) {
            for (int i = 0; i < text.length(); i++) {
                char symbol = text.charAt(i);
                if(!characterCount.containsKey(symbol)){
                    characterCount.put(symbol, 1);
                }else{
                    characterCount.put(symbol, characterCount.get(symbol)+1);
                }
            }
        }
        characterCount.forEach((k, v) -> System.out.printf("%c -> %d%n", k, v));
    }
}

