import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class legendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        Map<String, Integer> materialCount = new LinkedHashMap<>();
        materialCount.put("shards", 0);
        materialCount.put("fragments", 0);
        materialCount.put("motes", 0);
        boolean isObtained = false;
        String winningMaterial = "";
        while(!isObtained) {
            for (int i = 0; i < input.length; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase();
                if (!materialCount.containsKey(material)) {
                    materialCount.put(material, quantity);
                    if ((material.equals("shards") || material.equals("fragments") || material.equals("motes")) && materialCount.get(material) >= 250) {
                        materialCount.put(material, materialCount.get(material) - 250);
                        isObtained = true;
                        winningMaterial = material;
                        break;
                    }
                } else {
                    materialCount.put(material, materialCount.get(material) + quantity);
                    if ((material.equals("shards") || material.equals("fragments") || material.equals("motes")) && (materialCount.get(material) >= 250)) {
                        materialCount.put(material, materialCount.get(material) - 250);
                        isObtained = true;
                        winningMaterial = material;
                        break;
                    }
                }
            }
            if (!isObtained) {
                input = scanner.nextLine().split("\\s+");
            }

        }
            switch (winningMaterial){
                case "shards":
                    System.out.println("Shadowmourne obtained!");
                    break;
                case "fragments":
                    System.out.println("Valanyr obtained!");
                    break;
                case"motes":
                    System.out.println("Dragonwrath obtained!");
                    break;
            }
        materialCount.forEach((k, v) -> System.out.printf("%s: %d%n",k,v));
        }

    }

