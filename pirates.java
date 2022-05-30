import java.lang.reflect.AnnotatedArrayType;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class pirates {
    static class City {
        String name;
        int population;
        int gold;

        public City(String name, int population, int gold) {
            this.name = name;
            this.population = population;
            this.gold = gold;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, City> cities = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Sail")) {
            String[] cityInfo = input.split("[\\|]{2}");
            String cityName = cityInfo[0];
            int population = Integer.parseInt(cityInfo[1]);
            int gold = Integer.parseInt(cityInfo[2]);
            if (!cities.containsKey(cityName)) {
                City city = new City(cityName, population, gold);
                cities.put(cityName, city);
            } else {
                cities.get(cityName).setPopulation(cities.get(cityName).getPopulation() + population);
                cities.get(cityName).setGold(cities.get(cityName).getGold() + gold);
            }
            input = scanner.nextLine();
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandParts = command.split("=>");
            String key = commandParts[0];
            String name = commandParts[1];
            switch (key) {
                case "Plunder":
                    int people = Integer.parseInt(commandParts[2]);
                    int gold = Integer.parseInt(commandParts[3]);
                    cities.get(name).setPopulation(cities.get(name).getPopulation() - people);
                    cities.get(name).setGold(cities.get(name).getGold() - gold);
                    if (cities.get(name).getPopulation() <= 0 || cities.get(name).getGold() <= 0) {
                        cities.remove(name);
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", name, gold, people);
                        System.out.printf("%s has been wiped off the map!%n", name);
                    } else {
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", name, gold, people);
                    }
                    break;
                case "Prosper":
                    gold = Integer.parseInt(commandParts[2]);
                    if (gold >= 0) {
                        cities.get(name).setGold(cities.get(name).getGold() + gold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, name, cities.get(name).getGold());
                    } else {
                        System.out.println("Gold added cannot be a negative number!");
                        command = scanner.nextLine();
                        continue;
                    }
                    break;
            }
           command = scanner.nextLine();
        }
        if (!cities.isEmpty()) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());
            for (City city : cities.values()) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", city.getName(), city.getPopulation(), city.getGold());
            }
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
