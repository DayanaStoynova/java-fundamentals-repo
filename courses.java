import java.util.*;

public class courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, List<String>> courseCount = new LinkedHashMap<>();
        while (!line.equals("end")) {
            String[] command = line.split(" : ");
            String courseName = command[0];
            String studentName = command[1];
            if (!courseCount.containsKey(courseName)) {
               courseCount.put(courseName, new ArrayList<>());
               courseCount.get(courseName).add(studentName);
            } else {
                if(!courseCount.get(courseName).contains(studentName)){
                    courseCount.get(courseName).add(studentName);
                }

            }

            line = scanner.nextLine();
        }
        courseCount.forEach((key, value) -> {
            System.out.printf("%s: %d%n", key, value.size());
            value.forEach(e -> System.out.printf("-- %s%n", e));
        });
    }
}

