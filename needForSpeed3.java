import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class needForSpeed3 {
    static class Car {
        String car;
        int mileage;
        int fuel;

        public Car(String car, int mileage, int fuel) {
            this.car = car;
            this.mileage = mileage;
            this.fuel = fuel;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }

        public String getCar() {
            return car;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Car> cars = new LinkedHashMap<>();
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCars; i++) {
            String[] carInfo = scanner.nextLine().split("\\|");
            Car car = new Car(carInfo[0], Integer.parseInt(carInfo[1]), Integer.parseInt(carInfo[2]));
            cars.put(carInfo[0], car);
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] commandParts = command.split(" : ");
            String carName = commandParts[1];
            switch (commandParts[0]) {
                case "Drive":
                    int distance = Integer.parseInt(commandParts[2]);
                    int fuel = Integer.parseInt(commandParts[3]);
                    if (cars.get(carName).getFuel() >= fuel) {
                        cars.get(carName).setFuel(cars.get(carName).getFuel() - fuel);
                        cars.get(carName).setMileage(cars.get(carName).getMileage() + distance);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", carName, distance, fuel);
                        if (cars.get(carName).getMileage() >= 100000) {
                            System.out.printf("Time to sell the %s!%n", carName);
                            cars.remove(carName);
                        }
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    break;
                case "Refuel":
                    fuel = Integer.parseInt(commandParts[2]);
                    int initialFuel = cars.get(carName).getFuel();
                    int totalFuel = cars.get(carName).getFuel() + fuel;
                    if (totalFuel > 75) {
                        cars.get(carName).setFuel(75);
                    } else {
                        cars.get(carName).setFuel(cars.get(carName).getFuel() + fuel);
                    }
                    System.out.printf("%s refueled with %d liters%n", carName, cars.get(carName).getFuel() - initialFuel);
                    break;
                case "Revert":
                    int kilometres = Integer.parseInt(commandParts[2]);
                    int initialKm = cars.get(carName).getMileage();
                    int finalKm = initialKm-kilometres;
                    if(finalKm<10000){
                        cars.get(carName).setMileage(10000);
                    }else{
                        cars.get(carName).setMileage(cars.get(carName).getMileage()-kilometres);
                        System.out.printf("%s mileage decreased by %d kilometers%n",carName,initialKm-cars.get(carName).getMileage());
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        for(Car car: cars.values()){
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",car.getCar(),car.getMileage(),car.getFuel());
        }
    }
}
