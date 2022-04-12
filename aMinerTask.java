import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class aMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String resource = scanner.nextLine();
        Map<String, Integer> recourseQuantity = new LinkedHashMap<>();
        while(!resource.equals("stop")){
            int quantity = Integer.parseInt(scanner.nextLine());
            if(!recourseQuantity.containsKey(resource)){
                recourseQuantity.put(resource, quantity);
            }else{
                recourseQuantity.put(resource, recourseQuantity.get(resource)+quantity);
            }
            resource = scanner.nextLine();
        }
        recourseQuantity.forEach((k,v) -> System.out.printf("%s -> %d%n", k, v));
    }
}
