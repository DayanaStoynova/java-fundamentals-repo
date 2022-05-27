import java.util.Scanner;

public class passwordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder password = new StringBuilder(scanner.nextLine());
        StringBuilder resetPassword = new StringBuilder();
        String command = scanner.nextLine();
        while (!command.equals("Done")) {
            String[] commandParts = command.split(" ");
            switch (commandParts[0]) {
                case "TakeOdd":
                    for (int i = 1; i < password.length(); i++) {
                        if (i % 2 != 0) {
                            char symbol = password.charAt(i);
                            resetPassword.append(symbol);
                        }
                    }
                    password.setLength(0);
                    password.append(resetPassword);
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(commandParts[1]);
                    int length = Integer.parseInt(commandParts[2]);
                    password.delete(index, index+length);
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = commandParts[1];
                    String substitute = commandParts[2];
                    String newPass = "";
                    if(password.toString().contains(substring)){
                        newPass = password.toString().replaceAll(substring, substitute);
                    }else{
                        System.out.println("Nothing to replace!");
                        command = scanner.nextLine();
                        continue;
                    }
                    password.setLength(0);
                    password.append(newPass);
                    System.out.println(password);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", password);
    }
}
