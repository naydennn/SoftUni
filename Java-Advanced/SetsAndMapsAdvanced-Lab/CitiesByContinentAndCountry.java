import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            Map<String, List<String>> countries = continents.get(continent);
            if (countries == null) {
                countries = new LinkedHashMap<>();
                continents.put(continent, countries);
            }
            List<String> cities = countries.get(country);
            if (cities == null) {
                cities = new ArrayList<>();
                countries.put(country, cities);
            }
            cities.add(city);
            countries.put(country, cities);
            continents.put(continent, countries);
        }
        continents.forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach((key1, value1) -> System.out.println("  " + key1 + " -> " + String.join(", ", value1)));
        });
    }
}
