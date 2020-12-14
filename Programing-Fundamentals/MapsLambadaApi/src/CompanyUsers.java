import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companyInfo = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commands = input.split(" -> ");
            String companyName = commands[0];
            String employeeId = commands[1];

            List<String> id = companyInfo.get(companyName);
            if (id == null) {
                id = new ArrayList<>();
                companyInfo.put(companyName, id);
            }
            if (!companyInfo.get(companyName).contains(employeeId)) {
                id.add(employeeId);
                companyInfo.put(companyName, id);
            }

            input = scanner.nextLine();
        }
        companyInfo.entrySet().stream().sorted((a, b) -> a.getKey().compareTo(b.getKey())).forEach(a -> {System.out.println(a.getKey());
    a.getValue().forEach(b -> System.out.println("-- " + b));});
}
}
