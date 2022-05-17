import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class fancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("^[@][#]+(?<product>[A-Z][A-Za-z0-9]{4,}[A-Z])[@][#]+$");
        for (int i = 0; i < n; i++) {
            String barcode = scanner.nextLine();
            Matcher matcher = pattern.matcher(barcode);
            if (matcher.find()) {
                StringBuilder code = new StringBuilder();
                String product = matcher.group("product");
                Pattern numRegEx = Pattern.compile("[0-9]");
                Matcher numMatcher = numRegEx.matcher(product);
                for (int j = 0; j < product.length(); j++) {
                    if (numMatcher.find()){
                        int num = Integer.parseInt(numMatcher.group());
                        code.append(num);
                    }
                }
                if(code.length()==0){
                    code.append("00");
                }
                System.out.printf("Product group: %s%n", code);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
