import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String, Long>> citiesAndCountryInfo = new LinkedHashMap<>();
        Map<String, Long> countryInfo = new LinkedHashMap<>();

        while (!input.equals("report")) {
            String[] commands = input.split("\\|");
            String city = commands[0];
            String country = commands[1];
            long populations = Long.parseLong(commands[2]);

            Map<String, Long> citiesInfo = citiesAndCountryInfo.get(country);
            if (citiesInfo == null) {
                citiesInfo = new LinkedHashMap<>();
                countryInfo.put(country, 0L);
                citiesAndCountryInfo.put(country, citiesInfo);
            }
            citiesInfo.put(city, populations);
            citiesAndCountryInfo.put(country, citiesInfo);
            countryInfo.put(country, countryInfo.get(country) + populations);

            input = scanner.nextLine();
        }
        citiesAndCountryInfo.entrySet().stream()
                .sorted((c1,c2)-> countryInfo.get(c2.getKey()).compareTo(countryInfo.get(c1.getKey())))
                .forEach(country ->{
                    System.out.format("%s (total population: %d)%n",country.getKey(),countryInfo.get(country.getKey()));
                    country.getValue().entrySet()
                            .stream().sorted((t1,t2)-> t2.getValue().compareTo(t1.getValue())).forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(),city.getValue()));
                });
    }
}
