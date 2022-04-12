import java.util.*;

public class companyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, List<String>> companyList = new LinkedHashMap<>();
        while(!command.equals("End")){
            String[] line = command.split(" -> ");
            String companyName = line[0];
            String id = line[1];
            if(!companyList.containsKey(companyName)){
                companyList.put(companyName, new ArrayList<>());
                companyList.get(companyName).add(id);
            }else{
                if(!companyList.get(companyName).contains(id)){
                    companyList.get(companyName).add(id);
                }
            }
            command = scanner.nextLine();
        }
        companyList.forEach((key, value) -> {
            System.out.printf("%s %n", key);
            value.forEach(e -> System.out.printf("-- %s%n", e));
        });
    }
}
