import java.util.*;

public class orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Product> productPrice = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while(!input.equals("buy")){
            String[] line = input.split(" ");
            String name = line[0];
            double price = Double.parseDouble(line[1]);
            double quantity = Double.parseDouble(line[2]);
            if(productPrice.containsKey(name)){
                productPrice.get(name).setPrice(price);
                productPrice.get(name).setQuantity(productPrice.get(name).getQuantity()+quantity);
            }else{
               productPrice.put(name, new Product(name, price, quantity));
            }

            input = scanner.nextLine();
        }
            productPrice.forEach((k,v) -> System.out.printf("%s -> %.2f%n", k, v.getPrice()*v.getQuantity()));
    }
   static class Product{
        String name;
        double price;
        double quantity;

       public Product(String name, double price, double quantity) {
           this.name = name;
           this.price = price;
           this.quantity = quantity;
       }

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       public double getPrice() {
           return price;
       }

       public void setPrice(double price) {
           this.price = price;
       }

       public double getQuantity() {
           return quantity;
       }

       public void setQuantity(double quantity) {
           this.quantity = quantity;
       }
   }
}
