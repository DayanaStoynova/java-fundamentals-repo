import java.util.Locale;
import java.util.Scanner;

public class hogwarts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder spell = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();
        while (!command.equals("Abracadabra")) {
            String[] commandParts = command.split(" ");
            String keyWord = commandParts[0];
            switch (keyWord) {
                case "Abjuration":
                    String upperCaseSpell = spell.toString().toUpperCase(Locale.ROOT);
                    spell.setLength(0);
                    spell.append(upperCaseSpell);
                    System.out.println(spell);
                    break;
                case "Necromancy":
                    String lowerCaseSpell = spell.toString().toLowerCase(Locale.ROOT);
                    spell.setLength(0);
                    spell.append(lowerCaseSpell);
                    System.out.println(spell);
                    break;
                case "Illusion":
                    int index = Integer.parseInt(commandParts[1]);
                    String symbol = commandParts[2];
                    if (index >= 0 && index < spell.length()) {
                        spell.replace(index, index + 1, symbol);
                        System.out.println("Done!");
                    } else {
                        System.out.println("The spell was too weak.");
                    }
                    break;
                case "Divination":
                    String firstSub = commandParts[1];
                    String secondSub = commandParts[2];
                    String replaced = spell.toString().replaceAll(firstSub, secondSub);
                    spell.setLength(0);
                    spell.append(replaced);
                    System.out.println(spell);
                    break;
                case "Alteration":
                    String substring = commandParts[1];
                    if (spell.toString().contains(substring)) {
                        spell.delete(spell.indexOf(substring), spell.indexOf(substring)+substring.length());
                        System.out.println(spell);
                    } else {
                        command = scanner.nextLine();
                        continue;
                    }
                    break;
                default:
                    System.out.println("The spell did not work!");
            }
            command = scanner.nextLine();
        }
    }
}
