import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class messagesMenager {
    static class Account{
        String name;
        int sent;
        int received;

        public Account(String name, int sent, int received) {
            this.name = name;
            this.sent = sent;
            this.received = received;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSent() {
            return sent;
        }

        public void setSent(int sent) {
            this.sent = sent;
        }

        public int getReceived() {
            return received;
        }

        public void setReceived(int recieved) {
            this.received = recieved;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        Map<String, Account> accounts = new LinkedHashMap<>();
        int counter =0;
        while(!command.equals("Statistics")){
            String[] commandParts = command.split("=");
            String key = commandParts[0];
            switch (key){
                case "Add":
                    String name = commandParts[1];
                    int sent = Integer.parseInt(commandParts[2]);
                    int received = Integer.parseInt(commandParts[3]);
                    if(accounts.containsKey(name)){
                        command = scanner.nextLine();
                        continue;
                    }else{
                        counter++;
                        Account account = new Account(name,sent,received);
                        accounts.put(name,account);
                    }
                    break;
                case "Message":
                    String sender = commandParts[1];
                    String receiver = commandParts[2];
                    if(accounts.containsKey(sender) && accounts.containsKey(receiver)){
                        accounts.get(sender).setSent(accounts.get(sender).getSent()+1);
                        accounts.get(receiver).setReceived(accounts.get(receiver).getReceived()+1);
                        if(accounts.get(sender).getSent()+accounts.get(sender).getReceived()==capacity){
                            accounts.remove(sender);
                            counter--;
                            System.out.printf("%s reached the capacity!%n", sender);
                        }
                        if(accounts.get(receiver).getSent()+accounts.get(receiver).getReceived()==capacity){
                            accounts.remove(receiver);
                            counter--;
                            System.out.printf("%s reached the capacity!%n", receiver);
                        }
                    }
                    break;
                case "Empty":
                    String username = commandParts[1];
                    if(accounts.containsKey(username)) {
                        counter--;
                        accounts.remove(username);
                    }
                    if(username.equals("All")){
                        counter=0;
                        accounts.clear();
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Users count: %d%n",counter);
        for (Account account:accounts.values()) {
            System.out.printf("%s - %d%n",account.getName(), account.getReceived()+account.getSent());
        }
    }
}
