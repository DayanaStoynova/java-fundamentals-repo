import java.util.Locale;
import java.util.Scanner;

public class activationKey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder activationKey = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();
        while (!command.equals("Generate")) {
            String[] commandParts = command.split(">>>");
            String keyWord = commandParts[0];
            switch (keyWord) {
                case "Contains":
                    String substring = commandParts[1];
                    if (activationKey.toString().contains(substring)) {
                        System.out.printf("%s contains %s%n", activationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String caseType = commandParts[1];
                    int start = Integer.parseInt(commandParts[2]);
                    int end = Integer.parseInt(commandParts[3]);
                    String substringToChange = activationKey.substring(start, end);
                    String changedSubStr = "";
                    if (caseType.equals("Upper")) {
                        changedSubStr = substringToChange.toUpperCase(Locale.ROOT);
                    } else {
                        changedSubStr = substringToChange.toLowerCase(Locale.ROOT);
                    }
                    String newActivationKey = activationKey.toString().replaceAll(substringToChange, changedSubStr);
                    activationKey.setLength(0);
                    activationKey.append(newActivationKey);
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    start = Integer.parseInt(commandParts[1]);
                    end = Integer.parseInt(commandParts[2]);
                    activationKey.delete(start,end);
                    System.out.println(activationKey);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s",activationKey);
    }
}
