import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class messageTranslator {
    static class Command{
        String command;
        StringBuilder translation;

        public Command(String command, StringBuilder translation) {
            this.command = command;
            this.translation = translation;
        }

        public String getCommand() {
            return command;
        }

        public void setCommand(String command) {
            this.command = command;
        }

        public StringBuilder getTranslation() {
            return translation;
        }

        public void setTranslation(StringBuilder translation) {
            this.translation = translation;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Command> validStrings = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("[!](?<command>[A-Z][a-z]{2,})[!][:][\\[](?<string>[A-Za-z]{8,})[\\]]");
        Pattern lettersPattern = Pattern.compile("\\w");
        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if(!matcher.find()){
                System.out.println("The message is invalid");
                if(i<n) {
                    continue;
                }else {
                    break;
                }
            }else {
                String command = matcher.group("command");
                StringBuilder translation = new StringBuilder();
                Matcher lettersMatcher = lettersPattern.matcher(matcher.group("string"));
                while(lettersMatcher.find()){
                    int symbol = lettersMatcher.group().charAt(0);
                    translation.append(symbol);
                    translation.append(" ");
                }
                Command commandClass = new Command(command, translation);
                validStrings.put(command,commandClass);
            }
            for (Command command:validStrings.values()) {
                System.out.printf("%s: %s%n",command.getCommand(),command.getTranslation());
            }
        }
    }
}
