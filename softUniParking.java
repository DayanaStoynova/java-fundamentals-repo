import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class softUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, User> nameNumber = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            String command = line[0];
            switch (command){
                case "register":
                    String username = line[1];
                    String plateNumber = line[2];
                    if(!nameNumber.containsKey(username)){
                        nameNumber.put(username, new User(username, plateNumber));
                        System.out.printf("%s registered %s successfully%n", username, plateNumber);
                    }else{
                        System.out.printf("ERROR: already registered with plate number %s%n", nameNumber.get(username).getPlateNumber());
                    }
                    break;
                case "unregister":
                    String username1 = line[1];
                    if(!nameNumber.containsKey(username1)){
                        System.out.printf("ERROR: user %s not found%n", username1);
                    }else{
                        System.out.printf("%s unregistered successfully%n", username1);
                        nameNumber.remove(username1);
                    }
                    break;
            }
        }
        nameNumber.forEach((k, v) -> System.out.printf("%s => %s%n", k, v.getPlateNumber()));
    }
    static class User{
        String username;
        String plateNumber;

        public User(String username, String plateNumber) {
            this.username = username;
            this.plateNumber = plateNumber;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPlateNumber() {
            return plateNumber;
        }

        public void setPlateNumber(String plateNumber) {
            this.plateNumber = plateNumber;
        }
    }
}
