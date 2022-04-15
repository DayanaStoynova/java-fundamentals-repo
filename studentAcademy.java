import java.util.*;
import java.util.stream.Collectors;

public class studentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> studentGrade = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            Double grade = Double.parseDouble(scanner.nextLine());
            if(!studentGrade.containsKey(name)){
                studentGrade.put(name,new ArrayList<>());
                studentGrade.get(name).add(grade);
            }else{
                studentGrade.get(name).add(grade);
            }
        }
        studentGrade.forEach((key, value) -> {
            double avGrade = value
                    .stream()
                    .mapToDouble(x -> x)
                    .average()
                    .orElse(0.0);
            if(avGrade>= 4.50){
                System.out.printf("%s -> %.2f%n", key, avGrade);
            }
        });
    }
}
