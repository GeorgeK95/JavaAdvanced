import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class OfficeStuff {
    private static Map<String, Map<String, Integer>> companies = new TreeMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String regex = "\\|(.*)\\s-\\s(\\d+)\\s-\\s(.*)\\|";
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            Matcher matcher = Pattern.compile(regex).matcher(line);
            if (matcher.find()) {
                String company = matcher.group(1);
                String stock = matcher.group(3);
                int quantity = Integer.parseInt(matcher.group(2));
                companies.putIfAbsent(company, new LinkedHashMap<>());
                companies.get(company).putIfAbsent(stock, 0);
                companies.get(company).put(stock, companies.get(company).get(stock) + quantity);
            }
        }
        printInfo();
    }

    private static void printInfo() {
        for (Map.Entry<String, Map<String, Integer>> companyProducts : companies.entrySet()) {
            StringBuilder products = new StringBuilder();
            Map<String, Integer> value = companyProducts.getValue();
            for (Map.Entry<String, Integer> productQuantity : value.entrySet()) {
                String formatted = String.format("%s-%d", productQuantity.getKey(), productQuantity.getValue());
                products.append(formatted);
                products.append(", ");
            }
            products.delete(products.length() - 2, products.length());
            System.out.printf("%s: %s%n", companyProducts.getKey(), products);
        }
    }
}


